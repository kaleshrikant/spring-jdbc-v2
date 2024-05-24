package jdbc;

import jdbc.annot.DbConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PersonID | FirstName | LastName | Address  | City :\n");
        String personID = scanner.next();
        String firstName = scanner.next();
        String lastName = scanner.next();
        String address = scanner.next();
        String city = scanner.next();

        String sqlString = "INSERT INTO register.Persons VALUES(" + personID + ", " + lastName + ", " + firstName + ", " + address + ", " + city + ")";

       // int updateResult = jdbcTemplate.update(sqlString);

        int updateResult = jdbcTemplate.update("INSERT INTO register.Persons VALUES (?,?,?,?,?)", new Object[] {personID,lastName,firstName,address,city});

        System.out.println(updateResult + " Record inserted successfully.!");

    }
}
