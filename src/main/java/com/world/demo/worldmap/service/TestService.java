package com.world.demo.worldmap.service;

import com.world.demo.worldmap.entity.Test;
import com.world.demo.worldmap.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestService {
    @Autowired
    TestRepo testRepo;


    public void prepareList(){
        List<Test> testList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Test test = new Test();
            test.setName("Test "+i+1);

            testList.add(test);
        }
        testRepo.saveAll(testList);
//        return this.getTestList();
    }

    public List<Test> findAllList(){
        return testRepo.findAll();
    }

    public Test updateTest(Test test){
        return testRepo.save(test);
    }

}
