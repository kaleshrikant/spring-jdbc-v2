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
            JdbcTemplate is specially design for perform the all DDL and DML operations with database using spring JDBC.
            Note : JdbcTemplate is dependent on DriverManagerDataSource means we need to manage the Dependency injection using object.
            We can configure by : 
            a. Using XML
         **XML :**
            `<bean name="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
            <property name="dataSource" ref="dataSource"/>
            </bean>`
         **Client :**
            `public class ClientApplication {
            public static void main(String[] args) {
            Resource resource = new ClassPathResource("connection.xml");
            BeanFactory beanFactory = new XmlBeanFactory(resource);
            JdbcTemplate jdbcTemplate = (JdbcTemplate) beanFactory.getBean("jdbcTemplate");
          }`
            b. Using Annotation.
           `@Bean("jdbcTemplate")
            public JdbcTemplate getJdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(getDataSource());
            return jdbcTemplate;
            }`
          `AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
            JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
            jdbcTemplate.execute("INSERT INTO register.Persons VALUES(101, 'KALE', 'PRASHANT', 'MAHARASTRA', 'AMRAVATI')");
            System.out.println("Record inserted successfully.!");`
            4. call the **JdbcTemplate** bean in client application and work with database.
                A. int update(String sqlStatement, Object[]) : 
                   This method is used for pass the run time parameter to SQL statement witout using SQL injection technique and statement get executed succssfully return 1 otherwise 0.
                  `ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
                    JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter PersonID | FirstName | LastName | Address  | City :\n");
                    String personID = scanner.next();
                    String firstName = scanner.next();
                    String lastName = scanner.next();
                    String address = scanner.next();
                    String city = scanner.next();
                    String sqlString = "INSERT INTO register.Persons VALUES(" + personID + ", " + lastName + ", " + firstName + ", " + address + ", " + city + ")";
                    int updateResult = jdbcTemplate.update("INSERT INTO register.Persons VALUES (?,?,?,?,?)", new Object[] {personID,lastName,firstName,address,city});
                    System.out.println(updateResult + " Record inserted successfully.!");`
                B.You can use the one more version of update() method.
                   int update(String sqlStatement, PreparedStatementSetter);
                   String sqlStatement: parameter accept the sql statement in the form of String.
                   PreparedStatementSetter : this is the interface which is used to pass the parameter to Sql Statment
                   Just we need to use it in anonymous inner class.
            5. use **JdbcTemplate** methods to work with database.
               How to select record from Database using JdbcTemplate.
               A.) List query(String sqlSelectQuery, RowMapper) --> This is specially designed for select command.
               **String sqlSelectQuery** : this parameter is used for write the select query.
               **RowMapper** : an interface specially design for convert the database table row in pojo call model.

               **Steps to select data from RowMapper** :
               _________________________________________
               1. call JdbcTemplate
               2. create the pojo call according to database
               3. execute the query() method and store the pojo object.
               **Example** :
               _____________
                     `final String SELECT_QUERY = "SELECT * FROM register.Persons";
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
                   personsList.stream().forEach(System.out::println);`
