package by.koronatech.office.core.service.Impl;

import by.koronatech.office.core.Department;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentsPagination(int page, int recordsPerPage);
}
