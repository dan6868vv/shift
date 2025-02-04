	Задача:                                    Метод:           URL:					    

1. Получение всех отделов                            GET    localhost:8080/departments?page={Номер текущей страницы}&recordsPerPage={Кол-во записей на странице}
2. Добавление сотрудника в отдел 		     POST   localhost:8080/employees
3. Получение всех сотрудников отдела                 GET    localhost:8080/departments/sale?page={Номер текущей страницы}&recordsPerPage={Кол-во записей на странице}
4. Сделать сотрудника менеджером отдела              PATCH  localhost:8080/employees/manager/${id}
5. Изменение существующей информации о сотруднике    PUT    localhost:8080/employees/${id}
6. Удаление сотрудника из отдела                     DELETE localhost:8080/employees/${id}
