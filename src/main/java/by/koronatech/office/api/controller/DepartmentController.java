package by.koronatech.office.api.controller;

import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.Department;
import by.koronatech.office.core.service.Impl.DepartmentService;
import by.koronatech.office.core.service.Impl.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping
    public List<Department> getAll(@RequestParam("page") int page,
                                   @RequestParam("recordsPerPage")int recordsPerPage) { // Получение всех отделов
        return departmentService.getAllDepartmentsPagination(page, recordsPerPage);
    }

    @GetMapping("/{departmentName}") //Получение всех сотрудников отдела
    public List<GetEmployeeDTO> getDepartmentEmployee(@PathVariable("departmentName") String departmentName,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("recordsPerPage")int recordsPerPage) {
        return employeeService.getEmployeeByDepartmentPagination(departmentName,page,recordsPerPage);
    }
}
