package rnd.dev.redisrnd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rnd.dev.redisrnd.record.entity.CountryInfo;
import rnd.dev.redisrnd.record.request.CountryRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForGetOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForSaveOperation;
import rnd.dev.redisrnd.service.CountryService;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/save/country")
    public boolean saveBook(@RequestBody CountryRequestForSaveOperation countryRequestForSaveOperation) {
        return countryService.saveCountryInfo(countryRequestForSaveOperation);
    }

    @GetMapping("/get/country")
    public CountryInfo getCountry(@RequestBody CountryRequestForGetOperation countryRequestForGetOperation) {
        return countryService.getCountryInfo(countryRequestForGetOperation);
    }

    @DeleteMapping("/delete/country")
    public boolean deleteCountry(@RequestBody CountryRequestForDeleteOperation countryRequestForDeleteOperation) {
        return countryService.deleteCountryInfo(countryRequestForDeleteOperation);
    }
}
