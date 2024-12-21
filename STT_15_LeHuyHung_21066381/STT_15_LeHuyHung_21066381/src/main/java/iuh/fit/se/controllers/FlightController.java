package iuh.fit.se.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import iuh.fit.se.entities.Flight;
import iuh.fit.se.services.FlightService;



@Controller
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public String listFlights(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
        return "flights/list";
    }

    @GetMapping("/add")
    public String addFlightForm(Model model) {
        model.addAttribute("flight", new Flight(0, null, null, null, null, null, 0, false));
        return "flights/add";
    }

    @PostMapping
    public String saveFlight(@ModelAttribute("flight") Flight flight) {
        flightService.saveFlight(flight);
        return "redirect:/flights";
    }

    @GetMapping("/delete/{id}")
    public String deleteFlight(@PathVariable("id") int id) {
        flightService.deleteFlight(id);
        return "redirect:/flights";
    }
}