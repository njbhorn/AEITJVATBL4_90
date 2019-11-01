package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class MainController {
	
	
	
	public MainController () {
		
	}

	@GetMapping(value="/car")
	public List<Car> getCarInfoRaw(@PathVariable(value="type") int type)  {
		CarFactory cf  ;
		List<Car> out = null ;
		try {
			cf = new CarFactory() ;
			cf.initialise("Car.data");
			out = cf.getCarsRawData() ;
		} catch (IOException e) {
			e.printStackTrace();
		} 
				
		return out;
	}
	
	@GetMapping(value="/car")
	public List<Car> getDefaultList() {
		return getCarInfoRaw(1) ;
	}

}
