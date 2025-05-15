package rnd.dev.redisrnd.service;

import rnd.dev.redisrnd.record.entity.CountryInfo;
import rnd.dev.redisrnd.record.request.CountryRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForGetOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForSaveOperation;

public interface CountryService {
    boolean saveCountryInfo(CountryRequestForSaveOperation countryRequestForSaveOperation);
    CountryInfo getCountryInfo(CountryRequestForGetOperation countryRequestForGetOperation);
    boolean deleteCountryInfo(CountryRequestForDeleteOperation countryRequestForDeleteOperation);
}
