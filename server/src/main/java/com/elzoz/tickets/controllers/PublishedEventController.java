package com.elzoz.tickets.controllers;

import com.elzoz.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.elzoz.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.elzoz.tickets.domain.entities.Event;
import com.elzoz.tickets.mappers.EventMapper;
import com.elzoz.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/published-events")
public class PublishedEventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventResponseDto>> getPublishedEvents(
            @RequestParam(required = false) String q,
            Pageable pageable
    ){

        Page<Event> events;
        if(q != null && !q.trim().isEmpty())
            events = eventService.searchPublicEvents(q, pageable);
        else
            events = eventService.listPublishedEvents(pageable);

        return ResponseEntity.ok(events
                .map(eventMapper::toListPublishedEventResponseDto)
        );
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<GetPublishedEventDetailsResponseDto> getPublishedEventDetails(
            @PathVariable UUID eventId
    ){
        return eventService.getPublishedEvent(eventId)
                .map(eventMapper::toGetPublishedEventDetailsResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
