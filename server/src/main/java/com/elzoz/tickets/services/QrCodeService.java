package com.elzoz.tickets.services;

import com.elzoz.tickets.domain.entities.QrCode;
import com.elzoz.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);

    byte[] getQrImageForUserAndTicket(UUID userId, UUID ticketId);
}
