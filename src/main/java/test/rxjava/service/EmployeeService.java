package test.rxjava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import test.rxjava.exceptions.EmployeeNotFoundException;
import test.rxjava.repository.EmployeeRepository;
import test.rxjava.service.dto.EmployeeDto;
import test.rxjava.service.mapper.EmployeeMapper;

@Service
public class EmployeeService
{
    private EmployeeRepository employeeRepository;

    private final Scheduler scheduler;

    public EmployeeService(EmployeeRepository employeeRepository, @Qualifier("jdbcScheduler") Scheduler scheduler)
    {
        this.employeeRepository = employeeRepository;
        this.scheduler = scheduler;
    }

    @Transactional
    public Flux<EmployeeDto> findAll()
    {
        return asyncFlex(EmployeeMapper.instance.listToDtoList(employeeRepository.findAll()));
    }

    @Transactional
    public Flux<EmployeeDto> findEmployeesByName(String name)
    {
        return asyncFlex(EmployeeMapper.instance.listToDtoList(employeeRepository.findAllByName(name)));
    }

    @Transactional
    public Mono<EmployeeDto> getEmployeeDtoById(Mono<Long> employee_id) throws Exception
    {
        return Mono.just(EmployeeMapper.instance.toDto(employeeRepository.findById(employee_id.block()).orElseThrow(()-> new EmployeeNotFoundException(employee_id.block()))));
    }

    @Transactional
    public Mono<EmployeeDto> addEmployee(Mono<EmployeeDto> employeeDtoMono)
    {
        return Mono.just(EmployeeMapper.instance.toDto(employeeRepository
            .getOne(employeeRepository.saveAndFlush
                (EmployeeMapper.instance.toEntity(employeeDtoMono.block()))
                .getId())
        ));
    }

    @Transactional
    public Mono<String> deleteEmployee(Mono<Long> employee_id)
    {
        employeeRepository.deleteById(employee_id.block());
       return Mono.just(employeeRepository.findById(employee_id.block()).isPresent() ? "failed" : "success");

    }

    @Transactional
    public Mono<EmployeeDto> updateEmployee(Mono<EmployeeDto> employeeDtoMono){
        return  Mono.just(EmployeeMapper.instance.toDto(employeeRepository.saveAndFlush((EmployeeMapper.instance.toEntity(employeeDtoMono.block())))));
    }


    private Flux<EmployeeDto> asyncFlex(List<EmployeeDto> list)
    {
        return Flux.fromIterable(list);
    }
}
