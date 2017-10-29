package com.example.mockit;

import com.example.mockit.model.Stock;
import com.example.mockit.service.StockService;
import com.example.mockit.service.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MockitApplication {

	public static void main(String[] args) {

		new MockitApplication().example();
	}

	/**
	 * Implementation example
	 */
	public void example() {

		StockService stockService = new StockServiceImpl();

		Stock googleStock = new Stock("1","Google", 1);
		Stock microsoftStock = new Stock("2","Microsoft",1);

		List<Stock> stocks = new ArrayList<>();

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		Portfolio portfolio = new Portfolio();
		portfolio.setStockService(stockService);

		portfolio.setStocks(stocks);

		double value = portfolio.getMarketValue();

		System.out.println(value);
	}

}
