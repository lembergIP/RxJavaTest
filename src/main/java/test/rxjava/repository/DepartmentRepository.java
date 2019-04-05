package test.rxjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.rxjava.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
{

    List<Department> findAllByOrderByName();

    Department findFirstByName(String name);
}
