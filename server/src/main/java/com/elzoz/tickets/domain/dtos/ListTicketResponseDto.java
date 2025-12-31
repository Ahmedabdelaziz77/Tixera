package com.elzoz.tickets.domain.dtos;

import com.elzoz.tickets.domain.entities.TicketStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ListTicketResponseDto {

    private UUID id;

    private TicketStatusEnum status;

    private ListTicketResponseTicketTypeDto ticketType;

}
