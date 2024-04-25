package com.in28minutes.leanspringaop.aopexample.data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int [] { 11, 22, 33, 44, 55};
    }

}
