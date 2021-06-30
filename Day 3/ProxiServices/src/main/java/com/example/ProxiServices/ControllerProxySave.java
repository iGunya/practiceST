package com.example.ProxiServices;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Controller
public class ControllerProxySave {

    String URL_1 = "http://localhost:8080/save-file";
    String URL_2 = "http://localhost:8090/save-file";
    String URL_3 = "http://localhost:8095/save-file";

    String[] URL =new String[]{URL_1,URL_2,URL_3};

    private final String PATH_SAVE_FILE="./save";
    final int COUNT_RECORDING=3;

    @GetMapping("/input-file")
    public String toImput(){
        return "inputFile";
    }

    @PostMapping("/input-file")
    public String simplePost(@RequestParam(value="fileName") MultipartFile file, Model model) throws IOException {

        CountDownLatch cdl = new CountDownLatch(COUNT_RECORDING-1);

        // запись файла через 3 потока
        // cdl синхранизирует главный поток с 2 первыми закончившими запись
        for (int i = 0; i < COUNT_RECORDING; i++) {
            int finalI = i+1;
            new Thread(() -> {
                MultiValueMap<String, Object> body = null;
                try {
                    body = getMultivalueMap(file);
                    body.add("number",finalI);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);
                HttpEntity requestEntity = new HttpEntity<>(body, headers);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.postForEntity(URL[finalI-1], requestEntity, String.class);

                //записываем где точно были сохранены файлы
                if (response.getStatusCode() == HttpStatus.OK) {
                    synchronized (model) {
                        if(cdl.getCount()!=0)
                            model.addAttribute("stream" + cdl.getCount(), URL[finalI-1]);
                        cdl.countDown();
                    }
                }
            }).start();
        }
        try {
            cdl.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //так как cdl ждет 10 сек проверяем сколько записанно
        model.addAttribute("size", model.asMap().size());
        return "assureRecord";
    }


    private MultiValueMap<String, Object> getMultivalueMap(MultipartFile file) throws IOException {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
            ByteArrayResource contentsAsResource = new ByteArrayResource(file.getBytes()){
                @Override
                public String getFilename(){
                    return file.getOriginalFilename();
                }
            };
            map.add("fileName", contentsAsResource);
        return map;
    }
}
