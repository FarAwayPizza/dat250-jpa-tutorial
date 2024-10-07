DAT250 Experiment 2 - Report

Link to github: https://github.com/FarAwayPizza/dat250-jpa-tutorial/tree/master/src/main/java/no/hvl/dat250/jpa/tutorial

### 1. **Explain the used database and how/when it runs.**

We are using the **H2 database**. H2 is an in-memory relational database engine commonly used for development and testing purposes. It allows us to test database functionalities without needing a dedicated database server.

- **When it runs**: The database is initialised when you run the JPA application, either through the `CreditCardsMain` class or by running tests. The H2 database is automatically set up and used during the persistence lifecycle.

- **How it works**:

    - The persistence.xml file specifies H2 as the database provider, and Hibernate as the Object-Relational Mapping framework.
    - When you run the application, Hibernate uses the configurations in `persistence.xml` to create tables based on your entity classes.
    - The connection details are set through properties in `persistence.xml`.
    - The setting `hibernate.hbm2ddl.auto="update"` ensures that the schema is updated automatically based on the entity classes.

### 2. **Can you provide the SQL used to create the table `Customer`?**

```
CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
```

## Technical Problems Encountered

The main problem seemed to be some error that happened during the initial set up. At the group session I was told that I needed to re-fork the project and start over again. This  fixed the issues I was having and made it possible to actually run the project. Though this ment that I had spent a lot of time on nothing tangible.

Here or a few errors that occurred while working on the task.

- **Error with JoinColumn**: Encountered an error where the `@JoinColumn` annotation was not able to resolve the column `customer_id`.

    - **Attempted solutions**: Adjusted the database mapping and modified the `persistence.xml` configuration, updating `hibernate.hbm2ddl.auto` to `"update"`. This resolved some mapping issues.
- Had some struggles remember which to use between @One-to-many, @Many-to-one, @One-to-one and @Many-to-many.

- **Test Failures**: The `CreditCardsMainTest` failed with an annotation exception during the persistence of the domain model. This was caused by incorrect incorrect mappings between `Address` and `Customer`.

    - **Solution**: Revised entity mappings to ensure correctds bidirectional relationships.
    - Screenshots:

- **General Build Failures**: There were several issues during the initial build process, including classpath errors and unresolved columns in the entities.

    - **Solution**: Resolved by refining entity relationships and persistence configurations.
    - Screenshots:


## Database Tables Inspection

The database schema and tables were successfully generated with the corrected persistence settings. I used the H2 console to inspect the tables, which confirmed the creation of tables for `Customer`, `Address`, `Bank`, `CreditCard`, and `Pincode` with the expected relationships.

- **Tables Created**:
    - `Customer`: Contains columns for ID, name, and relationships to `Address` and `CreditCard`.
    - `Address`: Stores street, number, and associated customer data.
    - `Bank`: Contains bank details.
    - `CreditCard`: Stores credit card data including balance and limit.
    - `Pincode`: Stores pin details for the associated credit card.

## Pending Issues

**Fix Test Case Failure (`CreditCardsMainTest`):**

    - There’s still an issue with two of the tests in `CreditCardsMainTest`. The first one is on line 55: ```assertEquals(firstCard.getCreditLimit(), -10000);```
      The number it receives is 1000 and not -1000.  And I still have not managed to understand why this difference occurs. 
    - The second test that fails is on line 72: ```assertEquals(bank.getOwnedCards(), Set.of(firstCard, secondCard));``` where it expects and empty list but does not receive it. 



---
Second try:

### **Where are the database files stored?**:

The `connection.url` property provides information on where the H2 database stores its files:

```
<property name="hibernate.connection.url" value="jdbc:h2:file:./DB;DB_CLOSE_DELAY=-1"/>
```

- **`jdbc:h2:file:./DB`**: This indicates that the H2 database is set up to store its files in the `DB` folder located in the root of your project (the `./` means the current working directory, so in this case, the project folder).
- **`DB_CLOSE_DELAY=-1`**: This property tells the H2 database to keep the database connection open even after all connections are closed. This ensures that the data remains available for subsequent sessions.

