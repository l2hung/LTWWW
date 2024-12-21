package iuh.fit.se.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String airplaneName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(nullable = false)    
    private String departureAirport;

   @NotNull
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String arrivalAirport;
   
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date departureDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date arrivalDate;

    @Positive
    @NotNull
    @Column(nullable = false)
    private double seatFare;

    @Column(nullable = false)
    private boolean flightStatus;

    // Constructor mặc định
    public Flight() {}

    // Constructor đầy đủ
    public Flight(int flightId, String airplaneName, String departureAirport, String arrivalAirport, Date departureDate,
                  Date arrivalDate, double seatFare, boolean flightStatus) {
        this.flightId = flightId;
        this.airplaneName = airplaneName;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seatFare = seatFare;
        this.flightStatus = flightStatus;
    }

    // Getters và Setters
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getSeatFare() {
        return seatFare;
    }

    public void setSeatFare(double seatFare) {
        this.seatFare = seatFare;
    }

    public boolean isFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(boolean flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", airplaneName=" + airplaneName + ", departureAirport="
                + departureAirport + ", arrivalAirport=" + arrivalAirport + ", departureDate=" + departureDate
                + ", arrivalDate=" + arrivalDate + ", seatFare=" + seatFare + ", flightStatus=" + flightStatus + "]";
    }
}
