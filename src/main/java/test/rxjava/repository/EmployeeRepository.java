package test.rxjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import test.rxjava.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    @Query("select e from Employee e where lower(e.name) like lower(concat(?1,'%')) order by e.id")
    List<Employee> findAllByName(String name);

    List<Employee> findAllByOrderByName();
}
