/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.controller;


import com.world.demo.worldmap.service.CityService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohamed.Hamed
 */
@RestController
public class ApplicationController {
    @Autowired
    CityService cityService;
    
    
    @RequestMapping(value = "/")
    public String hello() {        
        try {

            System.out.println("=======================");
            return cityService.findCityByCode(Long.parseLong("149")).get(0).getDistrict();
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error";
    }
}
