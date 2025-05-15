package rnd.dev.redisrnd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rnd.dev.redisrnd.record.entity.BookInfo;
import rnd.dev.redisrnd.record.request.BookRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.BookRequestForGetOperation;
import rnd.dev.redisrnd.record.request.BookRequestForSaveOperation;
import rnd.dev.redisrnd.repository.BookInfoRepository;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookInfoRepository bookInfoRepository;

    @Override
    public boolean saveBookInfo(BookRequestForSaveOperation bookRequestForSaveOperation) {
        return bookInfoRepository.saveBookInfo(bookRequestForSaveOperation.getHashKey(), bookRequestForSaveOperation.getDataKey(), bookRequestForSaveOperation.getTtlSeconds(), bookRequestForSaveOperation.getBookInfo());
    }

    @Override
    public BookInfo getBookInfo(BookRequestForGetOperation bookRequestForGetOperation) {
        return bookInfoRepository.getBookInfo(bookRequestForGetOperation.getHashKey(), bookRequestForGetOperation.getDataKey());
    }

    @Override
    public boolean deleteBookInfo(BookRequestForDeleteOperation bookRequestForDeleteOperation) {
        return bookInfoRepository.deleteBookInfo(bookRequestForDeleteOperation.getHashKey(), bookRequestForDeleteOperation.getDataKey());
    }
}
