package com.davidhorstman.piggybank.controllers;

import com.davidhorstman.piggybank.models.Coin;
import com.davidhorstman.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {


    @Autowired
    CoinRepository coinRepos;

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> getTotalContents(){

        List<Coin> coins = new ArrayList<>();
        coinRepos.findAll().iterator().forEachRemaining(c->coins.add(c));
        for (Coin c :
                coins) {
            int quantity = c.getQuantity();
            System.out.print(quantity +" ");
            if(quantity == 1){
                System.out.println(c.getName());
            }
            else System.out.println(c.getNameplural());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
