package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date Checkin;
	private Date Checkon;
	
	//Consthurtors
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkon) {
		this.roomNumber = roomNumber;
		Checkin = checkin;
		Checkon = checkon;
	}
	
	//Getter's e Setter's
	public void setRoomnumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Integer getRoomnumber() {
		return this.roomNumber;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return Checkin;
	}

	public Date getCheckon() {
		return Checkon;
	}	
	
	//Method's
	
	public long duration() {
		
		long diff_milisegundos = Checkon.getTime() - Checkin.getTime();
		return TimeUnit.DAYS.convert(diff_milisegundos, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date Checkin, Date Checkout) {
		this.Checkin = Checkin;
		this.Checkon = Checkout;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Room " + this.getRoomnumber() +
				", Check-in: " + sdf.format(Checkin)+
				", Check -out: " + sdf.format(Checkon)+
				", " + duration() + " nigths..!";
	}
}
