package it.develhope.customqueries.Custom.Queries1.controllers;

import it.develhope.customqueries.Custom.Queries1.entities.Flight;
import it.develhope.customqueries.Custom.Queries1.entities.enums.Status;
import it.develhope.customqueries.Custom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = 15;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

@PostMapping("/")
    public List <Flight> createFlights(){
    List <Flight> flights = new ArrayList<>();
    for(int i=0; i<50; i++){
        Flight flight = new Flight();
        flight.setDescription(generatedString);
        flight.setFromAirport(generatedString);
        flight.setToAirport(generatedString);
        flight.setStatus(Status.ONTIME);
        flights.add(flight);
        flightRepository.saveAndFlush(flight);
    }
    return flights;
}


@GetMapping("/")
    public List<Flight> getAllFlights(){
    List<Flight> flightList = flightRepository.findAll();
    return flightList;
    }
}
