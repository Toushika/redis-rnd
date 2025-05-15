package rnd.dev.redisrnd.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import rnd.dev.redisrnd.record.entity.BookInfo;
import rnd.dev.redisrnd.utility.MapperUtils;

@Repository
public class BookInfoRepositoryImpl extends AbstractRedisRepository implements BookInfoRepository {
    public BookInfoRepositoryImpl(MapperUtils mapperUtils, RedisTemplate<String, String> redisTemplate) {
        super(mapperUtils, redisTemplate);
    }

    @Override
    public boolean saveBookInfo(String hashKey, String dataKey, long ttlSeconds, BookInfo bookInfo) {
        return saveData(hashKey, dataKey, ttlSeconds, bookInfo);
    }

    @Override
    public BookInfo getBookInfo(String hashKey, String dataKey) {
        return getData(hashKey, dataKey, BookInfo.class);
    }

    @Override
    public boolean deleteBookInfo(String hashKey, String dataKey) {
        return delete(hashKey, dataKey);
    }
}
