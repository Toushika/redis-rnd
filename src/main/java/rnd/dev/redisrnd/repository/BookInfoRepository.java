package rnd.dev.redisrnd.repository;

import rnd.dev.redisrnd.record.entity.BookInfo;

public interface BookInfoRepository {
    boolean saveBookInfo(String hashKey, String dataKey, long ttlSeconds, BookInfo bookInfo);
    BookInfo getBookInfo(String hashKey, String dataKey);
    boolean deleteBookInfo(String hashKey, String dataKey);
}
