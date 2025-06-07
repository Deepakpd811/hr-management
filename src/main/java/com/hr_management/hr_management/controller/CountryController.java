package com.hr_management.hr_management.controller;

import com.hr_management.hr_management.mapper.CountryMapper;
import com.hr_management.hr_management.model.dto.CountryDTO;
import com.hr_management.hr_management.model.entity.Country;
import com.hr_management.hr_management.model.entity.Region;
import com.hr_management.hr_management.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryMapper mapper;

    @GetMapping
    public List<CountryDTO> findAll(){
        List<Country> countryList = countryRepo.findAll();
        return countryList.stream().map(x->mapper.mapToCountryDTO(x) ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CountryDTO findUsingId(@PathVariable("id") String countryId){
        Country country = countryRepo.findByCountryId(countryId);

        if(country==null){
            throw new RuntimeException("Country Not Found");
        }
        return mapper.mapToCountryDTO(country);
    }
}
