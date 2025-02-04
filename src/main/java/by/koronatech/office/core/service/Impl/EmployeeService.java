package by.koronatech.office.core.service.Impl;


import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;

import java.util.List;

public interface EmployeeService {


    GetEmployeeDTO create(CreateEmployeeDTO createEmployeeDTO);

    void delete(long id);

    GetEmployeeDTO update(long id, CreateEmployeeDTO createEmployeeDTO);


    GetEmployeeDTO setEmployeeAsManager(long id);

    List<GetEmployeeDTO> getEmployeeByDepartmentPagination(String departmentName,int page,int recordsPerPage);
}
