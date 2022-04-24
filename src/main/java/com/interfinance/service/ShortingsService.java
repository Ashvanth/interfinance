package com.interfinance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interfinance.domain.Shortings;
import com.interfinance.repository.ShortingsRepository;
@Service
public class ShortingsService {
	
	private ShortingsRepository shortingsRepository;

	public ShortingsService(ShortingsRepository shortingsRepository) {
		this.shortingsRepository = shortingsRepository;
	}
	
	 public Iterable<Shortings> list() {
	        return shortingsRepository.findAll();
	    }
	 
	  public Shortings getIsinValue(String isin) {
		  System.out.println("Value of isin in String ======"+isin);
		  return shortingsRepository.findByisin(isin);
	    }
	 
	  public Shortings save(Shortings shortings) {
	        return shortingsRepository.save(shortings);
	    }

	    public void save(List<Shortings> shortings) {
	    	shortingsRepository.save(shortings);
	    }


}
