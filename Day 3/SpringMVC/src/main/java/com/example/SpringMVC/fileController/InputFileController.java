
package com.example.SpringMVC.fileController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Controller
public class InputFileController {

    private final String PATH_SAVE_FILE="./saveFail/";

    @GetMapping("/input-file")
    public String toImput(){
        return "inputFile";
    }

    @PostMapping("/input-file")
    public String simplePost(@RequestParam(value="fileName") MultipartFile file, Model model){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            model.addAttribute("lineFile", new String[] {br.readLine(), br.readLine()});
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        //сохранени файла
        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(PATH_SAVE_FILE+file.getOriginalFilename()));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "outputFile";
    }
}