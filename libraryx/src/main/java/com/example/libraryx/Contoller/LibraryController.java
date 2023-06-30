package com.example.libraryx.Contoller;

import com.example.libraryx.Entity.Library;
import com.example.libraryx.Repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lib")
public class LibraryController
{
    @Autowired
    public LibraryRepo repo;
    @PostMapping("/add")
    public ResponseEntity<Library>postvalues(@RequestBody Library library)
    {
        return new ResponseEntity<>(repo.save(library),HttpStatus.CREATED);
//        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(library));
//        return ResponseEntity.ok(repo.save(library));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Library>>getall()
    {
        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Library>getlibrary(@PathVariable int id)
    {
        Optional<Library>lib=repo.findById(id);
        if(lib.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else
        {
            Library next=lib.get();
           return ResponseEntity.ok(next);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Library>update(@RequestBody Library library,@PathVariable int id)
    {
        Library lb=null;
        Optional<Library>lib=repo.findById(id);
        if(lib.isPresent())
        {
          lb=lib.get();
          lb.setBook(library.getBook());
          lb.setAuthor(library.getAuthor());
          return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.save(lb));
        }
        else
        {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>deleteid(@PathVariable int id)
    {
        Optional<Library> link=repo.findById(id);
        if(link.isPresent())
        {
            repo.deleteById(id);
            return ResponseEntity.ok(true);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
    @GetMapping("/getname/{book}")
    public ResponseEntity<Library>getbybook(@PathVariable String book)
    {

        Optional<Library>lib=repo.findByBook(book);
        if(lib.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else
        {
            Library next=lib.get();
            return ResponseEntity.ok(next);
        }
    }
}



