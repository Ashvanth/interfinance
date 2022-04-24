package com.interfinance.repository;

import org.springframework.data.repository.CrudRepository;

import com.interfinance.domain.Shortings;

public interface ShortingsRepository extends CrudRepository<Shortings,String> {

	Shortings findByisin(String isin);
}
