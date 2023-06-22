# Pagination and Sorting - Spring Data JPA

---
### Quickstart 
`application.yml`

```agsl
spring:
  datasource:
    url: jdbc:mysql://<IP/localhost>:<PORT>/<YOUR_DATABASE_SCHEMA>       # jdbc:mysql://localhost:3306/pagination_test
    username: <YOUR_DB_USERNAME>     
    password: <YOUR_DB_PASSWORD>
```
---

### @Order(x) annotation
```agsl
- define the order of execution for an annotated component or bean.
- higher the x, higher the priority 
- The highest precedence component runs first.

Example:

@Component
@Order(1)
public class Excellent implements Rating {

    @Override
    public int getRating() {
        return 1;
    }
}

@Component
@Order(2)
public class Good implements Rating {

    @Override
    public int getRating() {
        return 2;
    }
}


```