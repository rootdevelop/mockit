package com.example.mockit.repository;

import com.example.mockit.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

    Stock findByName(String name);
}
