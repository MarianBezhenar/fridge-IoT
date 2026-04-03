package com.marian.demo_gtakb;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FrigoController {

    @Autowired
    FrigoService service;

    @Value("${frg.secret.key}")
    private String fridgeSecretKey;

    @GetMapping("/getFridgeDetails")
    public ResponseEntity<?> getFrigoDetails(@RequestHeader ("FRIDGE_KEY") String key){

        if(!fridgeSecretKey.equalsIgnoreCase(key)){
            return  ResponseEntity.status(403).body("Unauthorized");
        }

        return ResponseEntity.ok(service.getFrigoDetails());
    }

    //Data from Arduino
    @PostMapping("/addFridgeDetail")
    public String addFrigoDetail(@RequestBody Rilevazione fDetail){
        fDetail.setTimestame(LocalDateTime.now());
        service.addFrigoDetail(fDetail);
        return "Success";
    }

}
