package com.example.exampleappevent.service;

import com.example.exampleappevent.event.Publisher;
import com.example.exampleappevent.event.RegisteredCat;
import com.example.exampleappevent.model.Cat;
import com.example.exampleappevent.model.Event;
import com.example.exampleappevent.repository.CatRepository;
import com.example.exampleappevent.repository.EventRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;
    private final EventRepository eventRepository;
    private final ApplicationEventPublisher publisher;

    public CatService(CatRepository catRepository, EventRepository eventRepository, ApplicationEventPublisher publisher) {
        this.catRepository = catRepository;
        this.eventRepository = eventRepository;
        this.publisher = publisher;
    }

    @Transactional
    public Cat registerCat(Cat cat) {
        var registeredCatEvent = new RegisteredCat("durian");
        this.publisher.publishEvent(registeredCatEvent);
        return this.catRepository.save(cat);
//        throw new RuntimeException("testing");
    }

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
