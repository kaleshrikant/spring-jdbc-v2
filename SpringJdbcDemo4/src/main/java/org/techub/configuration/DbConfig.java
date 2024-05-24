package org.techub.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {

    @Bean(name = "driverManagerDataSource")
   public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            driverManagerDataSource.setUsername("shrikant");
            driverManagerDataSource.setPassword("Kale@333");
            driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/register");
        return driverManagerDataSource;
    }

   @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(getDriverManagerDataSource());
        return jdbcTemplate;
   }
}
