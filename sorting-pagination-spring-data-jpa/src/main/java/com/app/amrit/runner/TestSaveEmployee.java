package com.app.amrit.runner;

import com.app.amrit.entity.Employee;
import com.app.amrit.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Order(10)
public class TestSaveEmployee implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public void run(String... args) throws Exception {
        repo.saveAll(
                Arrays.asList(
                    new Employee(10, "James", 270.0, "DEV"),
                    new Employee(11, "Alex", 250.0, "QA"),
                    new Employee(12, "Eric", 210.0, "BA"),
                    new Employee(13, "John", 320.0, "DEV"),
                    new Employee(14, "Josey", 380.0, "QA"),
                    new Employee(15, "Alexis", 310.0, "BA"),
                    new Employee(16, "Samantha", 460.0, "DEV"),
                    new Employee(17, "Jasmine", 422.0, "QA"),
                    new Employee(18, "Kyle", 410.0, "BA")
                )
        );
    }
}
