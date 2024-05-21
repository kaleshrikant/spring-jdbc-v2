# spring-jdbc-v2

Project Steps: 
____________________
1. a
2. add required dependencies.
Spring Core
    'spring-core', version: '5.3.33'
 Spring Context
    'spring-context', version: '5.3.33'
 Spring JDBC
    'spring-jdbc', version: '5.3.33'
 MySql Connector.
    'mysql-connector-java', version: '8.0.33'
3. configure the **DriverManagerDataSource** class and load the database configurations.
   `String driverClassName`
   `String userName`
   `String password`
   `String url`
4. configure the **JdbcTemplate** for work with database.
5. call the **JdbcTemplate** bean in client application and work with database.
6. use **JdbcTemplate** methods to work with database.


