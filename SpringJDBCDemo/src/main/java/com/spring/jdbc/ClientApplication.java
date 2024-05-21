package com.spring.jdbc;

import com.spring.jdbc.annot.DbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        jdbcTemplate.execute("INSERT INTO register.Persons VALUES(101, 'KALE', 'PRASHANT', 'MAHARASTRA', 'AMRAVATI')");

        System.out.println("Record inserted successfully.!");

    }
}
