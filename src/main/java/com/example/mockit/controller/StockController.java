package com.example.mockit.controller;

import com.example.mockit.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping("/")
    public String getStockCount() {
        long count = stockRepository.count();
        return String.valueOf(count);
    }

}
