package aplplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[]args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int numRoom = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-on date (dd/MM/yyyy): ");
		Date checkOn = sdf.parse(sc.next());
		
		if(!checkOn.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after Check-In date ! XXxxXXxXXxXxx");
		}else {
			Reservation reserva = new Reservation(numRoom, checkIn, checkOn);
			System.out.println("Reservation: " +reserva.toString());
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-on date (dd/MM/yyyy): ");
			checkOn = sdf.parse(sc.next());
			
			String error = reserva.updateDates(checkIn, checkOn);

			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation: " + error);
			}
			
		}
		sc.close();
	}

}
