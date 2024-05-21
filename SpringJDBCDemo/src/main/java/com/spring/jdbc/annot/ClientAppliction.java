package com.spring.jdbc.annot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ClientAppliction {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(DbConfig.class);

        DriverManagerDataSource driverManagerDataSource = (DriverManagerDataSource) applicationContext.getBean("dataSource");

        if (driverManagerDataSource != null) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Database is not connected");
        }

    }
}
