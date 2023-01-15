package com.example.exampleappevent.repository;

import com.example.exampleappevent.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
