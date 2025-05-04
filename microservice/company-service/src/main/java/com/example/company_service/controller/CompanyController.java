package com.example.company_service.controller;

import com.example.company_service.common.ListDto;
import com.example.company_service.entity.CompanyDto;
import com.example.company_service.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("/add")
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }

//    @GetMapping("/all")
//    public ResponseEntity<ListDto<CompanyDto>> getAllCompany(@RequestBody Pageable pageable) {
//        return ResponseEntity.ok((ListDto<CompanyDto>) companyService.getAllCompanies(pageable).getList());
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto, @PathVariable Long id) {
        return ResponseEntity.ok(companyService.updateCompany(id , companyDto));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id, @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.getCompanyById(companyDto, id));
    }
}
