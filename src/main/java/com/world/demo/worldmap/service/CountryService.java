/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.service;

import com.world.demo.worldmap.entity.Country;
import com.world.demo.worldmap.repo.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohamed
 */
@Component
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    
    public Country findCountryByCode(String code) throws Exception{
        return countryRepository.findByCode(code);
    }
}
