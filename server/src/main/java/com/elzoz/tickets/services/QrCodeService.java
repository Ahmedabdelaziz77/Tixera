package com.elzoz.tickets.services;

import com.elzoz.tickets.domain.entities.QrCode;
import com.elzoz.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
