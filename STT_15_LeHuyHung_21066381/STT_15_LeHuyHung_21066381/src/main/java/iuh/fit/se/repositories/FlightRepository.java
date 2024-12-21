package iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iuh.fit.se.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
