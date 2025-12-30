package com.elzoz.tickets.controllers;

import com.elzoz.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.elzoz.tickets.domain.entities.Event;
import com.elzoz.tickets.mappers.EventMapper;
import com.elzoz.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/published-events")
public class PublishedEventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventResponseDto>> getPublishedEvents(
            Pageable pageable
    ){
        return ResponseEntity.ok(eventService.listPublishedEvents(pageable)
                .map(eventMapper::toListPublishedEventResponseDto));
    }
}
