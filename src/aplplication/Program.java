package aplplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[]args){
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int numRoom = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-on date (dd/MM/yyyy): ");
			Date checkOn = sdf.parse(sc.next());
			
			Reservation reserva = new Reservation(numRoom, checkIn, checkOn);
			System.out.println("Reservation: " +reserva.toString());
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-on date (dd/MM/yyyy): ");
			checkOn = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOn);
			System.out.println("Reservation: " + reserva.toString());
			
		}
		catch(ParseException a) {
			System.out.println("Invalid date format");
		}
		catch (DomainException b) {
			// TODO: handle exception
			System.out.println(b.getMessage());
		}
		sc.close();
	}

}
