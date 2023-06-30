package com.example.libraryx.Repo;

import com.example.libraryx.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepo extends JpaRepository<Library,Integer>
{

    Optional<Library> findByBook(String book);
}
