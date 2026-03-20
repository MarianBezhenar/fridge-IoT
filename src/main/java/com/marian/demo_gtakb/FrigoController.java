package com.marian.demo_gtakb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FrigoController {

    @Autowired
    FrigoService service;

    @GetMapping("/getFridgeDetails")
    public List<Rilevazione> getFrigoDetails(){
        return service.getFrigoDetails();
    }

    //Data from Arduino
    @PostMapping("/addFridgeDetail")
    public String addFrigoDetail(@RequestBody Rilevazione fDetail){
        fDetail.setTimestame(LocalDateTime.now());
        service.addFrigoDetail(fDetail);
        return "Success";
    }

}
