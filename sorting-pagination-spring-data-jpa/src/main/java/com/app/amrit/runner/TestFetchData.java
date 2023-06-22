package com.app.amrit.runner;

import com.app.amrit.entity.Employee;
import com.app.amrit.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class TestFetchData implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public void run(String... args) throws Exception {

        //input
        Pageable p = PageRequest.of(1,3);

        //output
        Page<Employee> page = repo.findAll(p);

        //result
        page.getContent().forEach(System.out::println);

        // metadata
        System.out.println(page.isFirst());
        System.out.println(page.isLast());
        System.out.println(page.isEmpty());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
        System.out.println(page.getSize());
        System.out.println(page.hasContent());
    }
}
