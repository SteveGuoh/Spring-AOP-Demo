package com.in28minutes.leanspringaop.aopexample.business;

import com.in28minutes.leanspringaop.aopexample.annotations.TrackTime;
import com.in28minutes.leanspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int [] data = dataService1.retrieveData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // throw new RuntimeException("Exception in calculateMax");
        return Arrays.stream(data).max().orElse(0);
    }
}
