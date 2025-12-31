package com.elzoz.tickets.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ListTicketResponseTicketTypeDto {

    private UUID id;

    private String description;

    private Double price;
}
