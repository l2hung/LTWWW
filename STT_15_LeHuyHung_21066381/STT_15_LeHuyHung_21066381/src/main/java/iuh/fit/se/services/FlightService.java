package iuh.fit.se.services;
import java.util.List;

import iuh.fit.se.entities.Flight;


public interface FlightService {
    List<Flight> getAllFlights();
    Flight saveFlight(Flight flight);
    void deleteFlight(int id);
}