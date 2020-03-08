package com.parking.lot.service;

import java.util.List;

import com.parking.lot.model.Car;



public interface ParkingService {

	public String create_parking_lot(Integer count) throws Exception;

	public String park(Car car) throws Exception;

	public String leave(Integer ticketNo) throws Exception;

	public void status() throws Exception;

	public List<String> registration_numbers_for_cars_with_colour(String color) throws Exception;

	public List<Integer> slot_numbers_for_cars_with_colour(String color) throws Exception;

	public String slot_number_for_registration_number(String registrationNumber) throws Exception;

}