package com.marian.demo_gtakb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrigoService {

    @Autowired
    FrigoRepo repo;


    public List<Rilevazione> getFrigoDetails() {
        return repo.findAll();
    }

    public void addFrigoDetail(Rilevazione fDetail) {
        repo.save(fDetail);
    }
}
