package com.world.demo.worldmap.repo;

import com.world.demo.worldmap.entity.Country;
import com.world.demo.worldmap.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Integer> {
    public Test findById(int id);
}
