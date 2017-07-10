package com.huang.spring.configuration;

import com.huang.spring.scan.AutowireTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ServiceBean {

    @Autowired
    private AutowireTest autowireTest;

    @PostConstruct
    public void postContruct() {
        System.out.println("complete post contruct;");
    }
}
