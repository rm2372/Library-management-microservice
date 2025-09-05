package com.epam.libraray_service.Repository;

import com.epam.libraray_service.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {
    List<Library> findByUsername(String username);
    Library findByUsernameAndBook(String username, int book);
    List<Library> findByBook(int book);
}