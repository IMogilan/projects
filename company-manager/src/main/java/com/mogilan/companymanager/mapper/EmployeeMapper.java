package com.mogilan.companymanager.mapper;

import com.mogilan.companymanager.dao.entity.employee.EmployeeEntity;
import com.mogilan.companymanager.web.dto.employee.EmployeeDto;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EmployeeMapper")
@Scope("singleton")
@NoArgsConstructor
public class EmployeeMapper implements Mapper<EmployeeEntity, EmployeeDto>{

    @Override
    public EmployeeDto mapDtoFromEntity(EmployeeEntity entity) {
        return EmployeeDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public EmployeeEntity mapEntityFromDto(EmployeeDto dto) {
        return EmployeeEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    @Override
    public List<EmployeeDto> mapListDtoFromListEntity(List<EmployeeEntity> entities) {
        List<EmployeeDto> result = new ArrayList<>();
        for (EmployeeEntity entity : entities) {
            EmployeeDto dto = this.mapDtoFromEntity(entity);
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<EmployeeEntity> mapListEntityFromListDto(List<EmployeeDto> dtoList) {
        List<EmployeeEntity> result = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            EmployeeEntity entity = this.mapEntityFromDto(dto);
            result.add(entity);
        }
        return result;
    }
}
