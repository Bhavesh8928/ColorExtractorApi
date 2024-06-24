package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class ColorExtractorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorExtractorApiApplication.class, args);
	}

//	@RequestMapping(value = "/")
//	public String index() {
//		return "index"; // This will serve the index.html from /resources/static
//	}

}
