package com.interfinance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interfinance.domain.Shortings;
import com.interfinance.service.ShortingsService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ShortingsService shortingService){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			TypeReference<List<Shortings>> typeReference = new TypeReference<List<Shortings>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/shortings.json");
			try {
				List<Shortings> shortings = mapper.readValue(inputStream,typeReference);
				shortingService.save(shortings);
				System.out.println("Shortings Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Shortings: " + e.getMessage());
			}
	    };
	}
}
