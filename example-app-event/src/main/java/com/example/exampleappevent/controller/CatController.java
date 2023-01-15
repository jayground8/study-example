package com.example.exampleappevent.controller;

import com.example.exampleappevent.model.Cat;
import com.example.exampleappevent.model.Event;
import com.example.exampleappevent.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping("/cats")
    public Cat regieterCat(@RequestBody Cat cat) {
        return this.catService.registerCat(cat);
    }

    @GetMapping("/cats")
    public List<Cat> getAllCat() {
        return this.catService.getAllCats();
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return this.catService.getAllEvents();
    }
}

