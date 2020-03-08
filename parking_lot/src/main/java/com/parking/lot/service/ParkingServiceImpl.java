package com.parking.lot.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.parking.lot.fileSystem.FileUtils;
import com.parking.lot.model.Car;
import com.parking.lot.model.Ticket;

public class ParkingServiceImpl implements ParkingService {

	@Override
	public String create_parking_lot(Integer count) throws Exception {
		FileUtils.removeFiles();
		Ticket tickets = new Ticket();
		LinkedHashMap<Integer, Car> maps = new LinkedHashMap<>();
		for (int i = 1; i <= count; i++) {
			maps.put(i, new Car("", ""));
		}
		tickets.setTicket(maps);
		FileUtils.writeObject(tickets);
		return "Created a parking lot with " + count + " slots";
	}

	@Override
	public String park(Car car) throws Exception {
		String response;
		Ticket ticket = FileUtils.ReadObject();
		if (isParkSlotEmpty(ticket)) {
			Integer ticketNo = getNearestTicket(ticket);
			LinkedHashMap<Integer, Car> slots = ticket.getTicket();
			slots.replace(ticketNo, car);
			ticket.setTicket(slots);
			FileUtils.writeObject(ticket);
			response = "Allocated slot number: " + ticketNo;
		} else {
			response = "Sorry, parking lot is full";
		}
		return response;
	}

	@Override
	public String leave(Integer ticketNo) throws Exception {
		Ticket ticket = FileUtils.ReadObject();
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		slots.replace(ticketNo, new Car("",""));
		ticket.setTicket(slots);
		FileUtils.writeObject(ticket);
		return "Slot number " + ticketNo + " is free";
	}

	@Override
	public void status() throws Exception {
		Ticket ticket = FileUtils.ReadObject();
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		System.out.println("Slot No." + "\t" + "Registration No" + "\t" + "Colour");
		for (int i = 1; i <= slots.size(); i++) {
			if (slots.get(i).getRegistrationNumber() != "") {
				System.out.print(i);
				System.out.print("\t"+"\t"+ slots.get(i).getRegistrationNumber());
				System.out.println("\t" + slots.get(i).getColor());
			}
		}
	}

	@Override
	public List<String> registration_numbers_for_cars_with_colour(String color) throws Exception {
		List<String> registrationNumbers = new ArrayList<String>();
		Ticket ticket = FileUtils.ReadObject();
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		for (int i = 1; i <= slots.size(); i++) {
			if (slots.get(i).getRegistrationNumber() != "") {
				if (slots.get(i).getColor().equalsIgnoreCase(color)) {
					registrationNumbers.add(slots.get(i).getRegistrationNumber());
				}
			}
		}
		return registrationNumbers;
	}

	@Override
	public List<Integer> slot_numbers_for_cars_with_colour(String color) throws Exception {
		List<Integer> slotNumbers = new ArrayList<Integer>();
		Ticket ticket = FileUtils.ReadObject();
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		for (int i = 1; i <= slots.size(); i++) {
			if (slots.get(i).getRegistrationNumber() != "") {
				if (slots.get(i).getColor().equalsIgnoreCase(color)) {
					slotNumbers.add(i);
				}
			}
		}
		return slotNumbers;
	}

	@Override
	public String slot_number_for_registration_number(String registrationNumber) throws Exception {
		String slotNo = "Not found";
		Ticket ticket = FileUtils.ReadObject();
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		for (int i = 1; i <= slots.size(); i++) {
			if (slots.get(i).getRegistrationNumber() != "") {
				if (slots.get(i).getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
					slotNo = String.valueOf(i);
				}
			}
		}
		return slotNo;
	}


	public boolean isParkSlotEmpty(Ticket ticket) throws Exception {
		boolean flag = false;
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		for(int i=1; i<=slots.size(); i++) {
			if(slots.get(i).getRegistrationNumber().equals("")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private Integer getNearestTicket(Ticket ticket) throws Exception {
		LinkedHashMap<Integer, Car> slots = ticket.getTicket();
		ArrayList<Integer> listOfTickets = new ArrayList<Integer>();
		for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
			if (entry.getValue().getRegistrationNumber().equals("")) {
				listOfTickets.add(entry.getKey());
			}
		}
		return listOfTickets.get(0);
	}

}
