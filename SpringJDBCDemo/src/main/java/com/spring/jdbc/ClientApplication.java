package com.spring.jdbc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ClientApplication {
    public static void main(String[] args) {

        Resource resource = new ClassPathResource("connection.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        DriverManagerDataSource driverManagerDataSource = (DriverManagerDataSource) beanFactory.getBean("dataSource");

        if (driverManagerDataSource != null) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Database is not connected");
        }
    }
}
