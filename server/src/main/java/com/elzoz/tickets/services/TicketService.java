package com.elzoz.tickets.services;

import com.elzoz.tickets.domain.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface TicketService {
    Page<Ticket> listTicketsForUser(UUID id, Pageable pageable);

    Optional<Ticket> getTicketForUser(UUID ticketId, UUID userId);
}
