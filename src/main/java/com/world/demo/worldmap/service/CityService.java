/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.service;


import com.world.demo.worldmap.entity.City;
import com.world.demo.worldmap.repo.CityRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Mohamed.Hamed
 */
@Component
public class CityService {
    @Autowired
    CityRepository cityRepository;
    
    public List<City> findCityByCode(Long id) throws Exception{
        List<City> optionalCity = cityRepository.findAll();
        System.out.println("==============================#####"+optionalCity);
        return (List<City>) optionalCity;
    }
}
