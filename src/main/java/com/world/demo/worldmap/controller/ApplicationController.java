/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.controller;

import com.world.demo.worldmap.entity.Country;
import com.world.demo.worldmap.service.CityService;
import com.world.demo.worldmap.service.CountryService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohamed.Hamed
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class ApplicationController {

    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;

    public ApplicationController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity getCountryByCode(@PathVariable String code) {
        try {
            Country country = countryService.findCountryByCode(code.toUpperCase());
            if (country != null) {
                return new ResponseEntity<>(country, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
