/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.world.demo.worldmap.repo;

import com.world.demo.worldmap.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohamed
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
    public Country findByCode(String code);
}
