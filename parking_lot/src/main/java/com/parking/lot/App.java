package com.parking.lot;

import com.parking.lot.model.Car;
import com.parking.lot.service.ParkingService;
import com.parking.lot.service.ParkingServiceImpl;

public class App 
{
	public static void main(String[] args){
		ParkingService service = new ParkingServiceImpl();
		switch(args[0]) {
		case "create_parking_lot" : {
			try {
				System.out.println(service.create_parking_lot(Integer.parseInt(args[1])));
			} catch (Exception e) {

				e.printStackTrace();
			}
			break;
		}

		case "park" : {
			try {
				Car car = new Car();
				car.setRegistrationNumber(args[1]);
				car.setColor(args[2]);
				System.out.println(service.park(car));	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case "leave" : {
			try {
				System.out.println(service.leave(Integer.parseInt(args[1])));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case "status" : {
			try {
				service.status();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case "registration_numbers_for_cars_with_colour" : {
			try {
				System.out.println(service.registration_numbers_for_cars_with_colour(args[1]));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case "slot_numbers_for_cars_with_colour" : {
			try {
				System.out.println(service.slot_numbers_for_cars_with_colour(args[1]));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		case "slot_number_for_registration_number" : {
			try {
				System.out.println(service.slot_number_for_registration_number(args[1]));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}

		default : {
			System.out.println("Invalid Input, try with valid command.");
			break;
		}
		}
	}
}
