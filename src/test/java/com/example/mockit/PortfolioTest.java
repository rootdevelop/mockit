package com.example.mockit;

import com.example.mockit.model.Stock;
import com.example.mockit.repository.StockRepository;
import com.example.mockit.service.StockService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class PortfolioTest {

    @Test
    public void getMarketValue() throws Exception {

        StockService stockService = mock(StockService.class);
        StockRepository stockRepository = mock(StockRepository.class);

        Stock googleStock = new Stock("Google", 1);
        Stock microsoftStock = new Stock("Microsoft",1);

        List<Stock> stocks = new ArrayList<>();

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        Portfolio portfolio = new Portfolio(stockRepository);
        portfolio.setStockService(stockService);

        portfolio.setStocks(stocks);

        when(stockRepository.findAll()).thenReturn(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(500);
        when(stockService.getPrice(microsoftStock)).thenReturn(500);

        int value = portfolio.getMarketValue();

        assertEquals(1000, value);

    }

}