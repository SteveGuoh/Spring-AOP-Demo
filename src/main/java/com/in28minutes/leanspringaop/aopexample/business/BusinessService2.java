package com.in28minutes.leanspringaop.aopexample.business;

import com.in28minutes.leanspringaop.aopexample.data.DataService1;
import com.in28minutes.leanspringaop.aopexample.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private final DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public int calculateMin() {
        int [] data = dataService2.retrieveData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // throw new RuntimeException("Exception in calculateMax");
        return Arrays.stream(data).min().orElse(0);
    }
}
