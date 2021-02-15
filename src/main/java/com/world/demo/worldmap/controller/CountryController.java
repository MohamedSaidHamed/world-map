/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.controller;

import com.world.demo.worldmap.entity.Country;
import com.world.demo.worldmap.entity.Test;
import com.world.demo.worldmap.service.CityService;
import com.world.demo.worldmap.service.CountryService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.world.demo.worldmap.service.TestService;
import com.world.demo.worldmap.utils.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Mohamed.Hamed
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;
    @Autowired
    TestService testService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/Code/{code}")
    public Country getCountryByCode(@PathVariable String code) throws Exception {

            Country country = countryService.findCountryByCode(code.toUpperCase());
            if (country != null) {
                return country;
            }
            throw new CountryNotFoundException("INVALID_COUNTRY_CODE");

    }
    @GetMapping(value = "/Test/")
    public List<Test> testTest() throws Exception {
        System.out.println("================================");
        testService.prepareList();
        Test test = new Test();
        test.setName("TEST FROM CONTROLLER");
        testService.updateTest(test);
        List<Test> testList = new ArrayList<>();
        testList = testService.findAllList();
        System.out.println("======"+testList);
        return testList;
    }
}
