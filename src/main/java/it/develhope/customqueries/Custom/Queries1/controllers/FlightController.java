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

@PostMapping("/")
    public List <Flight> createFlights(){

    List <Flight> flights = new ArrayList<>();
    for(int i=0; i<50; i++){
        Flight flight = new Flight();
        String generatedString1 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String generatedString2 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String generatedString3 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        flight.setDescription(generatedString1);
        flight.setFromAirport(generatedString2);
        flight.setToAirport(generatedString3);
        flight.setStatus(Status.ONTIME);
        flights.add(flight);
    }
    flightRepository.saveAllAndFlush(flights);
    return flights;
}


@GetMapping("/")
    public List<Flight> getAllFlights(){
    List<Flight> flightList = flightRepository.findAll();
    return flightList;
    }
}
//Documentazione Postman: https://documenter.getpostman.com/view/26121086/2s93eYTrtd