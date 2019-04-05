package test.rxjava.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import test.rxjava.entity.Department;
import test.rxjava.service.dto.DepartmentDto;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper instance = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDto(Department department);

    List<DepartmentDto> toListDto(List<Department> departments);
}
