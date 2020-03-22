package com.world.demo.worldmap;

import com.world.demo.worldmap.controller.CountryController;
import com.world.demo.worldmap.entity.Country;
import com.world.demo.worldmap.service.CountryService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorldMapApplicationTests {
    @Autowired
    CountryService countryService;

    @Test
    public void testGetCountryByCode_ValidCode() {
        System.out.println("testGetCountryByCode_ValidCode");
        String code = "BHR";
        CountryController instance = new CountryController(countryService);
//        Country result = instance.getCountryByCode(code);
//        assertEquals(result.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testGetCountryByCode_InvalidCode() {
        System.out.println("testGetCountryByCode_InvalidCode");
        String code = "InvalidCode";
        CountryController instance = new CountryController(countryService);
//        ResponseEntity result = instance.getCountryByCode(code);
//        assertEquals(result.getBody(), "INVALID_COUNTRY_CODE");
//        assertEquals(result.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //@Test
    public void testGetCountryByCode_Database_Is_Down() {
        System.out.println("testGetCountryByCode_Database_Is_Down");
        String code = "BHR";
        CountryController instance = new CountryController(countryService);
//        ResponseEntity result = instance.getCountryByCode(code);
//        assertEquals(result.getBody(), "INTERNAL_ERROR");
//        assertEquals(result.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
