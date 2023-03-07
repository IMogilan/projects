package com.mogilan.companymanager.service.employee;

import com.mogilan.companymanager.web.dto.employee.EmployeeDto;
import com.mogilan.companymanager.service.CrudService;
import com.mogilan.companymanager.service.PagingAndSortingService;

public interface EmployeeService extends CrudService<EmployeeDto, Long>, PagingAndSortingService<EmployeeDto> {

}
