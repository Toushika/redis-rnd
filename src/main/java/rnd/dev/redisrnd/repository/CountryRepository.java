package rnd.dev.redisrnd.repository;

import rnd.dev.redisrnd.record.entity.CountryInfo;

public interface CountryRepository {
    boolean saveCountryInfo(String hashKey, String dataKey, long ttlSeconds, CountryInfo countryInfo);
    CountryInfo getCountryInfo(String hashKey, String dataKey);
    boolean deleteCountryInfo(String hashKey, String dataKey);

}
