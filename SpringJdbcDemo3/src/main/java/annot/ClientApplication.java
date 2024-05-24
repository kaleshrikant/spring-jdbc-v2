package annot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PersonID | FirstName | LastName | Address  | City :\n");
        final String personID = scanner.next();
        final String firstName = scanner.next();
        final String lastName = scanner.next();
        final String address = scanner.next();
        final String city = scanner.next();


        // update with PreparedStatementSetterApp //
        int updateResult = jdbcTemplate.update("INSERT INTO register.Persons VALUES (?,?,?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,personID);
                ps.setString(2,lastName);
                ps.setString(3,firstName);
                ps.setString(4,address);
                ps.setString(5,city);
            }
        });

        System.out.println(updateResult + " Record inserted successfully.!");

    }
}
