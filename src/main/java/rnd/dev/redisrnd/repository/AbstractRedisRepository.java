package rnd.dev.redisrnd.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import rnd.dev.redisrnd.utility.MapperUtils;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractRedisRepository {
    private final MapperUtils mapperUtils;
    private final RedisTemplate<String, String> redisTemplate;


    protected <T> T getData(String hashKey, String dataKey, Class<T> tclass) {
        return mapperUtils.deSerialize(redisTemplate.opsForHash().get(hashKey, dataKey), tclass);
    }

    protected <T> T getData(String hashKey, Class<T> tclass) {
        return mapperUtils.deSerialize(redisTemplate.opsForValue().get(hashKey), tclass);
    }


    // save data  map
    protected <T> boolean saveData(String hashKey, String dataKey, long ttlSeconds, T data) {
        try {
            redisTemplate.opsForHash().put(hashKey, dataKey, mapperUtils.serialize(data));
            setValueWithExpiry(hashKey, ttlSeconds);
            return true;
        } catch (Exception e) {
            log.error("exception{}", e.getMessage());
            return false;
        }

    }

    // save data for string
    protected <T> boolean saveData(String hashKey, long ttlSeconds, T data) {
        try {
            redisTemplate.opsForValue().set(hashKey, mapperUtils.serialize(data));
            setValueWithExpiry(hashKey, ttlSeconds);
            return true;
        } catch (Exception e) {
            log.error("exception{}", e.getMessage());
            return false;
        }
    }

    // delete full Map
    protected boolean deleteFullMap(String hashKey) {
        try {
            redisTemplate.opsForHash().delete(hashKey);
            return true;
        } catch (Exception e) {
            log.error("exception{}", e.getMessage());
            return false;
        }
    }

    // delete map data
    protected boolean delete(String hashKey, String dataKey) {
        try {
            redisTemplate.opsForHash().delete(hashKey, dataKey);
            return true;
        } catch (Exception e) {
            log.error("exception{}", e.getMessage());
            return false;
        }
    }

    // delete String data

    protected boolean delete(String hashKey) {
        try {
            redisTemplate.opsForValue().getAndDelete(hashKey);
            return true;
        } catch (Exception e) {
            log.error("exception{}", e.getMessage());
            return false;
        }
    }


    public void setValueWithExpiry(String hashKey, long ttlSeconds) {
        redisTemplate.expire(hashKey, ttlSeconds, TimeUnit.SECONDS);
    }
}
