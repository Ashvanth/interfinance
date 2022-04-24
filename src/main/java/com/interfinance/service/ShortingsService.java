package com.interfinance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.interfinance.domain.Shortings;
import com.interfinance.repository.ShortingsRepository;

@Service
public class ShortingsService {
	
	private ShortingsRepository shortingsRepository;

	public ShortingsService(ShortingsRepository shortingsRepository) {
		this.shortingsRepository = shortingsRepository;
	}
	
	 public List<Shortings> list() {
		 Iterable<Shortings> shortingsFindAll = shortingsRepository.findAll();
		List<Shortings> shortingList = StreamSupport.stream(shortingsFindAll.spliterator(), false).map(shortings->{
			 Shortings shortingsObj = new Shortings();
			 BeanUtils.copyProperties(shortings, shortingsObj);
			 return shortingsObj;
		 }).collect(Collectors.toList());
		return shortingList;
	    }
	
	/*public List<Shortings> list() {
		 Iterable<Shortings> shortingsFindAll=shortingsRepository.findAll();
         List<Shortings> listObj = new ArrayList<Shortings>();
		 for(Shortings shortingsObj : shortingsFindAll)
		 {
			 listObj.add(shortingsObj);
		 }
		 return listObj;
	}*/
	 
	  public Shortings getIsinValue(String isin) {
		  return shortingsRepository.findByisin(isin);
	    }
	 
	  public Shortings save(Shortings shortings) {
	        return shortingsRepository.save(shortings);
	    }

	    public void save(List<Shortings> shortings) {
	    	shortingsRepository.save(shortings);
	    }


}
