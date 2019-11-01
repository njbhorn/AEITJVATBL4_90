package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControllerBasic {

	@GetMapping(value = "/car/{type}")
	public List<Car> getCarInfo(@PathVariable(value = "type") int type) {
		CarFactory cf;
		List<Car> out = null;
		try {
			cf = new CarFactory();
			cf.initialise("Car.data");

			switch (type) {
			case 1:
				out = cf.getCarsRawData();
				break;
			case 2:
				out = cf.getCarsFormattedData();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return out;
	}
	
	@GetMapping(value = "/car")
	public List<Car> getCarInfo() {
		return getCarInfo(1) ;
	}
	
	@GetMapping(value = "/demo")
	public Demo[] getDemoInfo() {
		Demo d = new Demo() ;
		Demo d2 = new Demo() ;
		d.id = 123 ;
		d.name = "fred";
		d2.id = 456 ;
		d2.name = "mary";
		Demo[] arr = { d, d2 } ;
		return arr ;
	}

}

class Demo {
	
	public Demo() {} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	int id ;
	String name ;
}