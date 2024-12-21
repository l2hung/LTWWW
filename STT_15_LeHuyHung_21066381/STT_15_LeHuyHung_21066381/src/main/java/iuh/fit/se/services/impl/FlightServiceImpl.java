package iuh.fit.se.services.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import iuh.fit.se.entities.Flight;
import iuh.fit.se.repositories.FlightRepository;
import iuh.fit.se.services.FlightService;


@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
}