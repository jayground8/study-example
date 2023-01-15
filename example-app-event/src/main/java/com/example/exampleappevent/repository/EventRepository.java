package com.example.exampleappevent.repository;

import com.example.exampleappevent.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
