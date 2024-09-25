import exceptions.InvalidDateException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Oisin Mc Laughlin
22441106
 */

public class Booking implements HealthPracticeAppointmentWebservice {
    private int patientNum;
    private HealthPractice hP;
    private LocalDateTime dateTime;
    private static int bookingCounter = 0;
    private int bookingID;

    public Booking(int patientNum, HealthPractice hP, LocalDateTime dateTime) throws InvalidDateException {
        // Check to make sure date isn't in past
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidDateException("Booking date and time cannot be in the past.");
        }

        this.patientNum = patientNum;
        this.hP = hP;
        this.dateTime = dateTime;

        // For each booking, increment the booking ID
        this.bookingID = ++bookingCounter;
    }

    // Overloaded construct for booking without date
    public Booking(int patientNum, HealthPractice hP) {
        this.patientNum = patientNum;
        this.hP = hP;
        this.dateTime = getBookingDateTime(hP);
    }

    // Getters
    public int getPatientNum() {
        return patientNum;
    }
    public HealthPractice getHealthPractice() {
        return hP;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public int getBookingID() {
        return bookingID;
    }

    // Setters
    public void setPatientNum(int patientNum) {
        if (patientNum <= 0) {
            throw new IllegalArgumentException("Invalid patient number");
        }
        else {
            this.patientNum = patientNum;
        }
    }

    // Reset method to fix errors of wrong bookingID
    public static void resetBookingCounter() {
        bookingCounter = 0;
    }

    // Setting date 1 month ahead if no date provided
    @Override
    public LocalDateTime getBookingDateTime(HealthPractice practice) {
        return LocalDateTime.now().plusMonths(1);
    }

    // ToString method with correct formatted date from assignment brief
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy 'at' HH:mm");
        String formattedDate = dateTime.format(formatter);

        String str = "";
        str += "Booking ID Number: " + bookingID + "\n";
        str += "Patient Number: " + patientNum + "\n";
        str += "Health Practice: " + hP.getHealthPracticeName() + "\n";
        str += "Address: " + hP.getHealthPracticeAddress() + "\n";
        str += "Date & Time: On " + formattedDate + "\n";

        // System.out.println(str);

        return str;
    }
}
