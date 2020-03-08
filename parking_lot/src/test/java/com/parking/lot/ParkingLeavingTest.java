package com.parking.lot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.parking.lot.fileSystem.FileUtils;
import com.parking.lot.model.Car;
import com.parking.lot.model.Ticket;
import com.parking.lot.service.ParkingServiceImpl;

public class ParkingLeavingTest {

	CreateParkingLotTest parkingLotTest = new CreateParkingLotTest();
	
	ParkingServiceImpl service = new ParkingServiceImpl();
	
	@Before
	@Test
	public void createParkingLot() {
		parkingLotTest.create_parking_lot_test();
	}
	
	@Test
	public void isParkSlotEmpty_test() {
		Ticket ticket = FileUtils.ReadObject();
		try {
			if(service.isParkSlotEmpty(ticket)) {
				assertEquals("Test passed for checking availability of slot",true, service.isParkSlotEmpty(ticket));
			}else {
				assertEquals("Test passed for checking availability of slot",false, service.isParkSlotEmpty(ticket));
			}
			
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void park_test() {
		Car car = new Car("KA-01-BB-0001","Black");
		try {
			assertEquals("Test passed for parking car","Allocated slot number: 1", service.park(car));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Ignore
	@Test
	public void leave_null_test() {
		try {
			assertNull("Test passed for leaving car from a lot", service.leave(null));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void leave_test() {
		try {
			assertEquals("Test passed for leaving car","Slot number 4 is free", service.leave(4));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	
	
	
}
