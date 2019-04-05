package test.rxjava.service.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;

    @NotBlank
    private String name;

    private Boolean active;

    @NotBlank
    private String departmentName;
}
