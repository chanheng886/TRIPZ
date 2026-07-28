package com.tripz.backend.Bus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Bus.dto.BusCompanyCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusCompanyDTO;
import com.tripz.backend.Bus.entities.BusCompany;
import com.tripz.backend.Bus.repositories.BusCompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusCompanyService {
    private final BusCompanyRepository busCompanyRepository;

    // 1. Method One
    // ✅✅ Get All Bus Company
    public List<BusCompanyDTO> getAllBusCompany(){
        return busCompanyRepository.findAll().stream().map(company ->{
            BusCompanyDTO dto = new BusCompanyDTO();
            dto.setId(company.getId());
            dto.setCompanyName(company.getCompanyName());
            dto.setImageUrl(company.getImageUrl());
           return dto;
        }).toList();
    }
    // 2 . Method Two
    // ✅✅ Create Bus Company
    public BusCompanyDTO createBusCompany(BusCompanyCreateRequestDTO request){
        BusCompany busCompany = BusCompany.builder()
        .companyName(request.getCompanyName())
        .imageUrl(request.getImageUrl()).build();

        BusCompany savedCompany = busCompanyRepository.save(busCompany);

        return BusCompanyDTO.builder()
        .id(savedCompany.getId())
        .companyName(savedCompany.getCompanyName())
        .imageUrl(savedCompany.getImageUrl()).build();
    }

    // 3 . Method Thre
    // ✅✅ Delete Bus Company
    public void deleteBusComapny(Integer id){
        busCompanyRepository.deleteById(id);
    }
}
