package rnd.dev.redisrnd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rnd.dev.redisrnd.record.entity.BookInfo;
import rnd.dev.redisrnd.record.request.BookRequestForDeleteOperation;
import rnd.dev.redisrnd.record.request.BookRequestForGetOperation;
import rnd.dev.redisrnd.record.request.BookRequestForSaveOperation;
import rnd.dev.redisrnd.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/save/book")
    public boolean saveBook(@RequestBody BookRequestForSaveOperation bookRequestForSaveOperation) {
        return bookService.saveBookInfo(bookRequestForSaveOperation);
    }

    @GetMapping("/get/book")
    public BookInfo getBook(@RequestBody BookRequestForGetOperation bookRequestForGetOperation) {
       return bookService.getBookInfo(bookRequestForGetOperation);
    }

    @DeleteMapping("/delete/book")
    public boolean deleteBook(@RequestBody BookRequestForDeleteOperation bookRequestForDeleteOperation) {
        return bookService.deleteBookInfo(bookRequestForDeleteOperation);
    }
}
