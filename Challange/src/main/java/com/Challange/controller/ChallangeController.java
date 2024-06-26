package com.Challange.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Challange.model.Challanges;
import com.Challange.service.ChallangeService;
import com.Challange.utils.Response;

@CrossOrigin(origins = "*")
@RestController
public class ChallangeController {
	@Autowired
    private ChallangeService challangeService;
    ResponseEntity responseObject = null;
    @GetMapping("/healths")
    public String healthCheck() {
        return "App is working perfectly with Spring Boot";
    }
    @PostMapping("/addChallanges")
    public ResponseEntity<Response> addChallange(@ModelAttribute Challanges challanges,
                                                 @RequestParam("image") MultipartFile file) throws IOException {
        // Convert MultipartFile to byte array
        challanges.setImageData(file.getBytes());
        
        Response response = challangeService.addChallange(challanges);
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/listChallanges")
    public ResponseEntity<List<Challanges>> getChallange() {
        try {
            List<Challanges> challanges = challangeService.list();
            return new ResponseEntity<>(challanges, HttpStatus.OK);
        } catch (Exception exception) {
            Response response = new Response();
            response.setMessage(exception.getMessage());
            response.setOperation(false);
            response.setStatusCode(500);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Challange/{id}")
    public ResponseEntity<Challanges> getChallange(@PathVariable int id) {
        try {
            Challanges challanges = challangeService.getChallange(id);
            return new ResponseEntity<>(challanges, HttpStatus.OK);
        } catch (Exception exception) {
            Response response = new Response();
            response.setMessage(exception.getMessage());
            response.setOperation(false);
            response.setStatusCode(500);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
