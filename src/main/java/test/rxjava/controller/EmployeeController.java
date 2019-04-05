package test.rxjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.rxjava.service.EmployeeService;
import test.rxjava.service.dto.EmployeeDto;

@RestController
@RequestMapping("/api")
public class EmployeeController
{
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Flux<EmployeeDto> getAllEmployees()
    {
        return employeeService.findAll();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id)
    {
        return employeeService.deleteEmployee(Mono.just(id)).equals(Mono.just("success")) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/employee")
    public Mono<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee)
    {
        return employeeService.addEmployee(Mono.just(employee));
    }

    @GetMapping("/employee/search")
    public Flux<EmployeeDto> getEmployeesByName(@RequestParam("name") String searchName)
    {
        return employeeService.findEmployeesByName(searchName);
    }

    @PostMapping("/employee")
    public Mono<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employee)
    {
        return employeeService.updateEmployee(Mono.just(employee));
    }
}
