package com.elzoz.tickets.services;

import com.elzoz.tickets.domain.CreateEventRequest;
import com.elzoz.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
