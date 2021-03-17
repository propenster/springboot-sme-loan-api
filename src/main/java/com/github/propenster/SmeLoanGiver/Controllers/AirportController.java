package com.github.propenster.SmeLoanGiver.Controllers;

import com.github.propenster.SmeLoanGiver.Entity.Airport;
import com.github.propenster.SmeLoanGiver.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AirportController {

    @Autowired
    private AirportRepository repository;

    @PostMapping("/addAirport")
    public String saveAirport(@RequestBody Airport airport){
    repository.save(airport);
    return "Added Airport with id ";
    }

    @GetMapping("/findAllAirports")
    public List<Airport> getAllAirports(){
        return repository.findAll();
    }

    @GetMapping("/findAllAirports/{id}")
    public Optional<Airport> getAirport(@PathVariable String id){
        return repository.findById(id);
    }

    @DeleteMapping("/deleteAirport{id}")
    public String deleteBook(@PathVariable String id){
        repository.deleteById(id);
        return "Airport deleted with id: "+id;
    }


}
