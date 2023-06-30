package com.book.book.controller;

import com.book.book.entity.Book;
import com.book.book.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    RestTemplate temp;
    @PostMapping("/libra/create")
    public ResponseEntity<Library>libra(@RequestBody Library lib )
    {
        String url="http://localhost:8090/lib/add";
        ResponseEntity<Library>lisa=temp.postForEntity(url,lib,Library.class);
        return ResponseEntity.ok(lisa.getBody());
    }
    @PostMapping("/addbook/cre")
    public  ResponseEntity<Book>Resbook(@RequestBody Book boo)
    {
        String xs="http://localhost:8081/api/library/createbook";
        ResponseEntity<Book>we=temp.postForEntity(xs,boo, Book.class);
        return ResponseEntity.ok(we.getBody());
    }
    @GetMapping("/geta/liba")
    public ResponseEntity<List<Library>>jeda()
    {
        String ur="http://localhost:8090/lib/getall";
        List<Library> re=temp.getForObject(ur,List.class);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(re);
    }
    @GetMapping("/getas/{id}")
    public ResponseEntity<Library>id(@PathVariable int id)
    {
        String url="http://localhost:8090/lib/get/{id}";
        Library x=temp.getForObject(url,Library.class,id);
        return ResponseEntity.ok(x);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId)
    {
        String url = "http://localhost:8081/api/library/deletebook/{bookId}";
        temp.delete(url,bookId,Book.class);
        return ResponseEntity.ok("Book deleted successfully");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Library>pos(@PathVariable int id,@RequestBody Library libe)
    {
        String url="http://localhost:8090/lib/update/{id}";
        libe.setId(id);
        temp.put(url,libe,id,Library.class);
        return ResponseEntity.ok(libe);
    }


}
//@Autowired
//    RestTemplate restTemplate;
//
//    @GetMapping("/getbook")
//    public List<Book> getAllBook(){
//        String url="http://localhost:8081/api/library/getbook";
//        List output = restTemplate.getForObject(url,List.class);
//        return output;
//    }
//    @PostMapping("/addbook")
//    public Book addBook(@RequestBody Book book)
//    {
//        String url = "http://localhost:8081/api/library/createbook";
//        ResponseEntity<Book> response = restTemplate.postForEntity(url, book, Book.class);
//        return response.getBody();
//    }
//    @GetMapping("/get/{bookId}")
//    public Book getBookById(@PathVariable Long bookId) {
//        String url = "http://localhost:8081/api/library/getbook/{bookId}";
//        return restTemplate.getForObject(url, Book.class, bookId);
//    }
//
//    @PutMapping("/update/{bookId}")
//    public Book updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
//        String url = "http://localhost:8081/api/library/updatebook/{bookId}";
//        restTemplate.put(url, updatedBook, bookId,Book.class);
//        return updatedBook;
//    }
//
