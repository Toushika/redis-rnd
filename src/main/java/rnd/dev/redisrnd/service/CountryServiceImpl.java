package rnd.dev.redisrnd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rnd.dev.redisrnd.record.entity.CountryInfo;
import rnd.dev.redisrnd.record.request.CountryRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForGetOperation;
import rnd.dev.redisrnd.record.request.CountryRequestForSaveOperation;
import rnd.dev.redisrnd.repository.CountryRepository;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public boolean saveCountryInfo(CountryRequestForSaveOperation countryRequestForSaveOperation) {
        return countryRepository.saveCountryInfo(countryRequestForSaveOperation.getHashKey(), countryRequestForSaveOperation.getDataKey(), countryRequestForSaveOperation.getTtlSeconds(), countryRequestForSaveOperation.getCountryInfo());
    }

    @Override
    public CountryInfo getCountryInfo(CountryRequestForGetOperation countryRequestForGetOperation) {
      return countryRepository.getCountryInfo(countryRequestForGetOperation.getHashKey(), countryRequestForGetOperation.getDataKey());
    }

    @Override
    public boolean deleteCountryInfo(CountryRequestForDeleteOperation countryRequestForDeleteOperation) {
        return countryRepository.deleteCountryInfo(countryRequestForDeleteOperation.getHashKey(), countryRequestForDeleteOperation.getDataKey());
    }
}
