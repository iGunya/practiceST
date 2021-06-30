package com.example.backServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


@Controller
public class BackServicesController {
    private final String PATH_SAVE_FILE="./save";

    @PostMapping("/save-file")
    public ResponseEntity saveFile(@RequestParam(value="fileName") MultipartFile file,
                                   @RequestParam(value="number") Integer number){
        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(
                            PATH_SAVE_FILE + number + "/" + file.getOriginalFilename()));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
