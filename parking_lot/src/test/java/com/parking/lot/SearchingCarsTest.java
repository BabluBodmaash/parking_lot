package com.parking.lot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.service.ParkingService;
import com.parking.lot.service.ParkingServiceImpl;

public class SearchingCarsTest {

	ParkingService service = new ParkingServiceImpl();
	
	ParkingLeavingTest parkTest = new ParkingLeavingTest();
	
	@Before
	@Test
	public void createParkingLotAndParkCar() {
		parkTest.park_test();
	}
	
	@Test
	public void registration_numbers_for_cars_with_colour_test() {
		String color = "Black";
		List<String> registrationNumbers = new ArrayList<String>();
		registrationNumbers.add("KA-01-BB-0001");
		try {
			assertEquals("Test passed : registration_numbers_for_cars_with_colour",registrationNumbers, service.registration_numbers_for_cars_with_colour(color));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void slot_numbers_for_cars_with_colour_test() {
		String color = "Black";
		List<Integer> slotNumbers = new ArrayList<Integer>();
		slotNumbers.add(1);
		try {
			assertEquals("Test passed : slot_numbers_for_cars_with_colour",slotNumbers, service.slot_numbers_for_cars_with_colour(color));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void slot_number_for_registration_number_test() {
		String registrationNumber = "KA-01-BB-0001";
		String slot = "3";
		try {
			assertEquals("Test passed : slot_number_for_registration_number",slot, service.slot_number_for_registration_number(registrationNumber));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	
}
