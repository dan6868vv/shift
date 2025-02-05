package by.koronatech.office.core.service;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.Employee;
import by.koronatech.office.core.mapper.office.CreateEmployeeMapper;
import by.koronatech.office.core.mapper.office.GetEmployeeMapper;
import by.koronatech.office.core.service.Impl.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final GetEmployeeMapper getEmployeeMapper;
    private final CreateEmployeeMapper createEmployeeMapper;
    private final List<Employee> cacheRepository = new ArrayList<>(
            List.of(
                    Employee.builder().id(1L).name("Maria Bozhe").salary(12.3).department("sale").manager(false).build(),
                    Employee.builder().id(2L).name("Danila Zubar").salary(1.23).department("sale").manager(false).build(),
                    Employee.builder().id(3L).name("Andrey Trifonov").salary(52.6).department("clean").manager(false).build(),
                    Employee.builder().id(4L).name("Blue Gay").salary(5335.3).department("legal").manager(false).build(),
                    Employee.builder().id(5L).name("My Mom").salary(857.36).department("legal").manager(false).build(),
                    Employee.builder().id(6L).name("Dima Pok").salary(3135.6).department("programmer").manager(false).build()
            )
    );




    @Override
    public GetEmployeeDTO create(CreateEmployeeDTO createEmployeeDTO) {
        cacheRepository.add(createEmployeeMapper.toEntity(createEmployeeDTO));
        return getEmployeeMapper.toDto(createEmployeeMapper.toEntity(createEmployeeDTO));
    }

    @Override
    public void delete(long id) {
        cacheRepository.remove(findById(id));
    }

    @Override
    public GetEmployeeDTO update(long id, CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = findById(id);
        createEmployeeMapper.merge(employee, createEmployeeDTO);
        return getEmployeeMapper.toDto(employee);
    }

    @Override
    public GetEmployeeDTO setEmployeeAsManager(long id) {
        Employee employee = findById(id);
        employee.setManager(true);
        return getEmployeeMapper.toDto(employee);
    }

    @Override
    public List<GetEmployeeDTO> getEmployeeByDepartmentPagination(String departmentName, int page, int recordsPerPage) {
        return getEmployeeMapper.toDtos(
                cacheRepository.stream()
                        .filter(employee -> employee.getDepartment().equals(departmentName))
                        .skip((long) (page - 1) * recordsPerPage)
                        .limit(recordsPerPage)
                        .collect(Collectors.toList())
        );
    }
    private Employee findById(long id) {
        return cacheRepository.stream().filter(office -> office.getId() == id).findFirst().
                orElse(null);
    }
}
