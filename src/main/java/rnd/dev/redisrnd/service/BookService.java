package rnd.dev.redisrnd.service;

import rnd.dev.redisrnd.record.entity.BookInfo;
import rnd.dev.redisrnd.record.request.BookRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.BookRequestForGetOperation;
import rnd.dev.redisrnd.record.request.BookRequestForSaveOperation;

public interface BookService {
    boolean saveBookInfo(BookRequestForSaveOperation bookRequestForSaveOperation);
    BookInfo getBookInfo(BookRequestForGetOperation bookRequestForGetOperation);
    boolean deleteBookInfo(BookRequestForDeleteOperation bookRequestForDeleteOperation);
}
