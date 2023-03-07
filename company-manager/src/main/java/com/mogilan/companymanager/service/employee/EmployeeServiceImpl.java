package com.mogilan.companymanager.service.employee;

import com.mogilan.companymanager.web.dto.employee.EmployeeDto;
import com.mogilan.companymanager.dao.entity.employee.EmployeeEntity;
import com.mogilan.companymanager.exceptionhandler.exception.employee.NoSuchEmployeeException;
import com.mogilan.companymanager.mapper.EmployeeMapper;
import com.mogilan.companymanager.dao.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        var employeeEntity = employeeMapper.mapEntityFromDto(employeeDto);
        var newEmployeeEntity = employeeRepository.save(employeeEntity);
        var newEmployeeDto = employeeMapper.mapDtoFromEntity(newEmployeeEntity);
        return newEmployeeDto;
    }

    @Override
    public List<EmployeeDto> readAll() {
        List<EmployeeEntity> entities = employeeRepository.findAll();
        return employeeMapper.mapListDtoFromListEntity(entities);
    }

    @Override
    public EmployeeDto readById(Long id) {
        var employeeEntity = employeeRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchEmployeeException(id));
        var employeeDto = employeeMapper.mapDtoFromEntity(employeeEntity);
        return employeeDto;
    }

    @Override
    public boolean update(Long id, EmployeeDto employeeDto) {
        if(employeeRepository.existsById(id)){
            var employeeEntity = employeeMapper.mapEntityFromDto(employeeDto);
            employeeEntity.setId(id);
            employeeRepository.save(employeeEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<EmployeeDto> findPaginated(int pageNumber, int pageSize, String sortCondition, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortCondition).ascending() :
                Sort.by(sortCondition).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Page<EmployeeEntity> entityPage = employeeRepository.findAll(pageable);
        Page<EmployeeDto> dtoPage = entityPage.map(employeeMapper::mapDtoFromEntity);
        return dtoPage;
    }
}

