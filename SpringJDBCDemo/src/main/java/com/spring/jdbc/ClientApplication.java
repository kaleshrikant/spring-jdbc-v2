package com.spring.jdbc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClientApplication {
    public static void main(String[] args) {

        Resource resource = new ClassPathResource("connection.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) beanFactory.getBean("jdbcTemplate");

        jdbcTemplate.execute("INSERT INTO register.Persons VALUES(101, 'KALE', 'SHRIKANT', 'MAHARASTRA', 'AMRAVATI')");

        System.out.println("Record inserted successfully.!");

    }
}
