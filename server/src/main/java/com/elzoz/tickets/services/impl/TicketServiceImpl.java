package com.elzoz.tickets.services.impl;

import com.elzoz.tickets.domain.entities.Ticket;
import com.elzoz.tickets.repositories.TicketRepository;
import com.elzoz.tickets.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Page<Ticket> listTicketsForUser(UUID id, Pageable pageable) {
        return ticketRepository.findByPurchaserId(id, pageable);
    }

    @Override
    public Optional<Ticket> getTicketForUser(UUID ticketId, UUID userId) {
        return ticketRepository.findByIdAndPurchaserId(ticketId, userId);
    }
}
