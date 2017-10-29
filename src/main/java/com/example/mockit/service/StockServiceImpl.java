package com.example.mockit.service;

import com.example.mockit.model.Stock;

public class StockServiceImpl implements StockService {

    @Override
    public int getPrice(Stock stock) {
        return 100;
    }
}
