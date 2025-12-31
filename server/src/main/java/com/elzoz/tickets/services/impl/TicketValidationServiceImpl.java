package com.elzoz.tickets.services.impl;

import com.elzoz.tickets.domain.entities.*;
import com.elzoz.tickets.exceptions.QrCodeNotFoundException;
import com.elzoz.tickets.exceptions.TicketNotFoundException;
import com.elzoz.tickets.repositories.QrCodeRepository;
import com.elzoz.tickets.repositories.TicketRepository;
import com.elzoz.tickets.repositories.TicketValidationRepository;
import com.elzoz.tickets.services.TicketValidationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketValidationServiceImpl implements TicketValidationService {


    private final QrCodeRepository qrCodeRepository;
    private final TicketRepository ticketRepository;
    private final TicketValidationRepository ticketValidationRepository;

    @Override
    public TicketValidation validateTicketByQrCode(UUID qrCodeId) {
        QrCode qrCode = qrCodeRepository.findByIdAndStatus(qrCodeId, QrCodeStatusEnum.ACTIVE)
                .orElseThrow(() -> new QrCodeNotFoundException(
                String.format("QR Code with ID '%s' wasn't found!", qrCodeId)
        ));

        Ticket ticket = qrCode.getTicket();
        return validateTicket(ticket, TicketValidationMethod.QR_SCAN);
    }

    private TicketValidation validateTicket(Ticket ticket, TicketValidationMethod method) {
        TicketValidation ticketValidation = new TicketValidation();
        ticketValidation.setTicket(ticket);
        ticketValidation.setValidationMethod(method);

        TicketValidationStatusEnum ticketValidationStatus = ticket.
                getValidations().stream()
                .filter(t -> TicketValidationStatusEnum.VALID.equals(t.getStatus()))
                .findFirst()
                .map(t -> TicketValidationStatusEnum.INVALID)
                .orElse(TicketValidationStatusEnum.VALID);

        ticketValidation.setStatus(ticketValidationStatus);

        return ticketValidationRepository.save(ticketValidation);
    }

    @Override
    public TicketValidation validateTicketManually(UUID ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(TicketNotFoundException::new);

        return validateTicket(ticket, TicketValidationMethod.MANUAL);
    }
}
