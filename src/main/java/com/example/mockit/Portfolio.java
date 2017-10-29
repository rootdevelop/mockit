package com.example.mockit;

import com.example.mockit.model.Stock;
import com.example.mockit.repository.StockRepository;
import com.example.mockit.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Portfolio {

    final
    StockRepository stockRepository;

    private StockService stockService;

    @Autowired
    public Portfolio(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public Iterable<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    public void setStocks(List<Stock> stocks) {

        stockRepository.save(stocks);
    }

    public int getMarketValue() {
        int marketValue = 0;

        for (Stock stock : getStocks()) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}