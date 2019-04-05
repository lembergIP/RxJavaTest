package test.rxjava.service;


import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.scheduler.Scheduler;
import test.rxjava.repository.DepartmentRepository;
import test.rxjava.service.dto.DepartmentDto;
import test.rxjava.service.mapper.DepartmentMapper;

@Service
public class DepartmentService
{
    private DepartmentRepository departmentRepository;

    private final Scheduler scheduler;


    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, @Qualifier("jdbcScheduler") Scheduler scheduler) {
        this.departmentRepository = departmentRepository;
        this.scheduler = scheduler;
    }

    public Mono<Iterable<DepartmentDto>> findAll() {
        return async(() -> DepartmentMapper.instance.toListDto(departmentRepository.findAll()));
    }
    private <T> Mono<T> async(Callable<T> callable) {
        return Mono.fromCallable(callable).doOnEach(Signal::isOnComplete).publishOn(scheduler);
    }


}
