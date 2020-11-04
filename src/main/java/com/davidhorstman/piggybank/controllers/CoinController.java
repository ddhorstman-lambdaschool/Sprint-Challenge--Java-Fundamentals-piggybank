package com.davidhorstman.piggybank.controllers;

import com.davidhorstman.piggybank.models.Coin;
import com.davidhorstman.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CoinController {


    @Autowired
    CoinRepository coinRepos;

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> getTotalContents() {

        coinRepos.findAll().forEach(c -> {
            int quantity = c.getQuantity();
            System.out.println(quantity + " " + (quantity == 1 ? c.getName() : c.getNameplural()));
        });

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
