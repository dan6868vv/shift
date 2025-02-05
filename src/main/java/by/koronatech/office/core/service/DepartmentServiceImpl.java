package by.koronatech.office.core.service;

import by.koronatech.office.core.Department;
import by.koronatech.office.core.Employee;
import by.koronatech.office.core.service.Impl.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final List<Department> cacheRepository = new ArrayList<>(
            List.of(
                    Department.builder().id(1L).name("sale").build(),
                    Department.builder().id(2L).name("clean").build(),
                    Department.builder().id(3L).name("legal").build(),
                    Department.builder().id(4L).name("programmer").build()
            )
    );
    @Override
    public List<Department> getAllDepartmentsPagination(int page, int recordsPerPage) {
        return cacheRepository.stream()
                .skip((long) (page - 1) * recordsPerPage)
                .limit(recordsPerPage)
                .collect(Collectors.toList());
    }
}
