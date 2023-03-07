package com.mogilan.companymanager.web.controller;

import com.mogilan.companymanager.web.dto.employee.EmployeeDto;
import com.mogilan.companymanager.service.employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    public static final List<Integer> PAGE_SIZE_OPTIONS = new LinkedList<>(Arrays.asList(5, 10, 20, 50));

    @GetMapping
    public String showAllEmployees(Model model) {
        return findPaginated(1, PAGE_SIZE_OPTIONS.get(0), "firstName", "ASC", model);
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public String findPaginated(@PathVariable(value = "pageNumber") int pageNumber,
                                @PathVariable(value = "pageSize") int pageSize,
                                @RequestParam(value = "sortCondition") String sortCondition,
                                @RequestParam(value = "sortDirection") String sortDirection,
                                Model model) {
        Page<EmployeeDto> paginated = employeeService.findPaginated(pageNumber, pageSize, sortCondition, sortDirection);
        List<EmployeeDto> employees = paginated.getContent();

        model.addAttribute("employeesList", employees);

        model.addAttribute("currentPageNumber", pageNumber);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalElements", paginated.getTotalElements());

        model.addAttribute("pageSize", pageSize);
        LinkedList<Integer> newPageSizeOptions = new LinkedList<>(PAGE_SIZE_OPTIONS);
        newPageSizeOptions.remove(Integer.valueOf(pageSize));
        newPageSizeOptions.addFirst(pageSize);
        model.addAttribute("pageSizeOptions", newPageSizeOptions);

        model.addAttribute("sortCondition", sortCondition);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection",
                sortDirection.equalsIgnoreCase("ASC") ?
                "DESC" :
                "ASC");

        return "all-employees";
    }

    @GetMapping("/{id}")
    public String showEmployeeById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("employee", employeeService.readById(id));
        return "employee-info";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new-employee")
    public String showFormForNewEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-info";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("employee", employeeService.readById(id));
        return "employee-info";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-info";
        } else {
            employeeService.create(employee);
            return "redirect:/employee?success";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
}
