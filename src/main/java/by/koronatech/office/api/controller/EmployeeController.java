package by.koronatech.office.api.controller;


import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.service.Impl.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees")
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping //Создание сотрудника
    public GetEmployeeDTO create(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return employeeService.create(createEmployeeDTO);
    }

    @PutMapping("/{id}") // Изменение информации о сотруднике
    public GetEmployeeDTO update(@PathVariable long id,
                                 @RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return employeeService.update(id, createEmployeeDTO);
    }


    @DeleteMapping("/{id}") //Удаление сотрудника из отдела
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }

    @PatchMapping("manager/{id}")  //Сделать сотрудника менеджером отдела
    public GetEmployeeDTO setEmployeeAmManager(@PathVariable long id){
        return employeeService.setEmployeeAsManager(id);
    }



}
