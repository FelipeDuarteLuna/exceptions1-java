package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date Checkin;
	private Date Checkon;
	
	//Consthurtors
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkon) throws DomainException {
		if(!checkon.after(checkin)) {
			throw new DomainException("Error in reservation: Check-out date must be after Check-In date ! XXxxX- - CONSTRUTOR - -xXXxXxx");
		}
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
	
	public void  updateDates(Date Checkin, Date Checkout) throws DomainException {
		Date now = new Date(); // Criando uma data de agora, ora maquina.
		
		if(Checkin.before(now) || Checkout.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future ! XXxxXXxXXxXxx");
		}else if(!Checkout.after(Checkin)){
			throw new DomainException("Error in reservation: Check-out date must be after Check-In date ! XXxxXXxXXxXxx");
		}		
		this.Checkin = Checkin;
		this.Checkon = Checkout;
		//return "Reservation: " + this.toString();
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
