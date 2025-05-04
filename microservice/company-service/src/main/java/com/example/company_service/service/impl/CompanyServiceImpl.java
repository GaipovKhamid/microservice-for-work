package com.example.company_service.service.impl;

import com.example.company_service.common.ListDto;
import com.example.company_service.common.exps.NotFound;
import com.example.company_service.entity.CompanyDto;
import com.example.company_service.entity.CompanyEntity;
import com.example.company_service.repository.CompanyRepository;
import com.example.company_service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;


    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(companyDto.getName());
        companyEntity.setBudget(companyDto.getBudget());
        companyEntity.setEmployeeIds(companyDto.getEmployeeIds());

        companyRepository.save(companyEntity);
        companyDto.setId(companyEntity.getId());

        return companyDto;
    }

    @Override
    public CompanyDto updateCompany(Long id, CompanyDto dto) {
        var optional = companyRepository.findById(id);

        CompanyEntity companyEntity = optional.get();
        companyEntity.setName(dto.getName());
        companyEntity.setBudget(dto.getBudget());
        companyEntity.setEmployeeIds(dto.getEmployeeIds());

        companyRepository.save(companyEntity);

        return dto;
    }

//    @Override
//    public ListDto<CompanyDto> getAllCompanies(Pageable pageable) {
//        List<CompanyDto> companyDtoList = companyRepository.findAll(pageable).stream()
//                .map(companyEntity ->
//                        CompanyDto.builder()
//                                .id(companyEntity.getId())
//                                .name(companyEntity.getName())
//                                .budget(companyEntity.getBudget())
//                                .employeeIds(companyEntity.getEmployeeIds())
//                                .build())
//                .toList();
//        return new ListDto<>(companyDtoList);
//    }

    @Override
    public CompanyDto getCompanyById(CompanyDto dto, Long id) {
        var optional = companyRepository.findById(id);

        if (optional.isEmpty()) {
            throw new NotFound("Company not exist");
        }

        return dto;
    }

    @Override
    public void deleteCompanyById(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new NotFound("Company not exist");
        }

        companyRepository.deleteById(id);
    }
}
