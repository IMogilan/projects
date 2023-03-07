package com.mogilan.companymanager.dao.repository.employee;

import com.mogilan.companymanager.dao.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
