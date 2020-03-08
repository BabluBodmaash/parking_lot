package com.parking.lot.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class Ticket implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2430401780921504926L;
	
	public LinkedHashMap<Integer, Car> ticket;

	public LinkedHashMap<Integer, Car> getTicket() {
		return ticket;
	}

	public void setTicket(LinkedHashMap<Integer, Car> ticket) {
		this.ticket = ticket;
	}
}
