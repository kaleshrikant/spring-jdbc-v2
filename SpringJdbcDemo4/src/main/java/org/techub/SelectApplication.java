package org.techub;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.techub.configuration.DbConfig;
import org.techub.model.Persons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SelectApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        final String SELECT_QUERY = "SELECT * FROM register.Persons";
        List<Persons> personsList = jdbcTemplate.query(SELECT_QUERY, new RowMapper<Persons>() {
            @Override
            public Persons mapRow(ResultSet rs, int rowNum) throws SQLException {
                Persons persons = new Persons();
                persons.setPersonID(rs.getString(1));
                persons.setLastName(rs.getString(2));
                persons.setFirstName(rs.getString(3));
                persons.setAddress(rs.getString(4));
                persons.setCity(rs.getString(5));
                return persons;
            }
        });

        personsList.stream().forEach(System.out::println);

    }
}
