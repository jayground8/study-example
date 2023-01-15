package com.example.exampleappevent.listener;

import com.example.exampleappevent.event.RegisteredCat;
import com.example.exampleappevent.model.Event;
import com.example.exampleappevent.repository.EventRepository;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CatListener {
    private final EventRepository eventRepository;

    public CatListener(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Async
    @TransactionalEventListener(phase= TransactionPhase.AFTER_COMMIT)
    void handleEventAfterCommit(RegisteredCat event) {
        System.out.println("handleEventAfterCommit listener: " + event.getName());
    }

    @EventListener
    void handleEvent(RegisteredCat event) {
        System.out.println("handleEvent listener: " + event.getName());
        String payload = new Gson().toJson(event);
        this.eventRepository.save(new Event(RegisteredCat.class.getSimpleName(), payload));
        throw new RuntimeException("testing");
    }
}
