package com.example.company_service.service;

import com.example.company_service.common.ListDto;
import com.example.company_service.entity.CompanyDto;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto updateCompany(Long id, CompanyDto companyDto);

//    ListDto<CompanyDto> getAllCompanies(Pageable pageable);

    CompanyDto getCompanyById(CompanyDto dto, Long id);

    void deleteCompanyById(Long id);
}
