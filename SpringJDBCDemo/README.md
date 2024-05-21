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
5. use **JdbcTemplate** methods to work with database.


