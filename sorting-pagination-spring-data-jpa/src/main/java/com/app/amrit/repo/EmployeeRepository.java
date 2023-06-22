package com.app.amrit.repo;

import com.app.amrit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository< Employee,Integer> {
}
