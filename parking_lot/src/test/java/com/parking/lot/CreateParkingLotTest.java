package com.parking.lot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.parking.lot.fileSystem.FileUtils;
import com.parking.lot.service.ParkingService;
import com.parking.lot.service.ParkingServiceImpl;

public class CreateParkingLotTest {

	ParkingService service = new ParkingServiceImpl();
	
	@Test
	public void create_parking_lot_test() {
		FileUtils.removeFiles();
		try {
			assertEquals("Test case passed for creating lot","Created a parking lot with 10 slots", service.create_parking_lot(10));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());	
		}
	}
	
	@Test
	public void create_parking_lot_null_test() {
		try {
			assertNull("Test case passed for creating lot" ,service.create_parking_lot(null));
		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}
	
}
