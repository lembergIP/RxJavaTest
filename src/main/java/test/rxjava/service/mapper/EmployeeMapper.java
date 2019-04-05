package test.rxjava.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import test.rxjava.entity.Employee;
import test.rxjava.service.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper instance = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({@Mapping(source = "department.name", target = "departmentName")})
    EmployeeDto toDto(Employee employee);

    @Mappings({@Mapping(source = "departmentName", target = "department.name")})
    Employee toEntity(EmployeeDto employee);

    List<EmployeeDto> listToDtoList(List<Employee> employees);


}