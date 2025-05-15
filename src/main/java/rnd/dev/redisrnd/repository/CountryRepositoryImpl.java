package rnd.dev.redisrnd.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import rnd.dev.redisrnd.record.entity.CountryInfo;
import rnd.dev.redisrnd.utility.MapperUtils;
@Repository
public class CountryRepositoryImpl extends AbstractRedisRepository implements CountryRepository{
    public CountryRepositoryImpl(MapperUtils mapperUtils, RedisTemplate<String, String> redisTemplate) {
        super(mapperUtils, redisTemplate);
    }

    @Override
    public boolean saveCountryInfo(String hashKey, String dataKey, long ttlSeconds, CountryInfo countryInfo) {
        return saveData(hashKey, dataKey, ttlSeconds, countryInfo);
    }

    @Override
    public CountryInfo getCountryInfo(String hashKey, String dataKey) {
        return getData(hashKey, dataKey, CountryInfo.class);
    }

    @Override
    public boolean deleteCountryInfo(String hashKey, String dataKey) {
        return delete(hashKey, dataKey);
    }
}
