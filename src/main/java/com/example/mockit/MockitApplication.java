package com.example.mockit;

import com.example.mockit.model.Stock;
import com.example.mockit.repository.StockRepository;
import com.example.mockit.service.StockService;
import com.example.mockit.service.StockServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MockitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitApplication.class, args);
	}

	@Bean
	public CommandLineRunner example(StockRepository stockRepository) {
		return strings -> {
			StockService stockService = new StockServiceImpl();

			Stock googleStock = new Stock("Google", 1);
			Stock microsoftStock = new Stock("Microsoft",1);

			List<Stock> stocks = new ArrayList<>();

			stocks.add(googleStock);
			stocks.add(microsoftStock);

			Portfolio portfolio = new Portfolio(stockRepository);
			portfolio.setStockService(stockService);

			portfolio.setStocks(stocks);

			int value = portfolio.getMarketValue();

			System.out.println(value);
		};
	}


}
