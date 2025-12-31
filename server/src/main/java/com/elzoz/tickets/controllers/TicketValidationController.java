package com.elzoz.tickets.controllers;

import com.elzoz.tickets.domain.dtos.TicketValidationRequestDto;
import com.elzoz.tickets.domain.dtos.TicketValidationResponseDto;
import com.elzoz.tickets.domain.entities.TicketValidation;
import com.elzoz.tickets.domain.entities.TicketValidationMethod;
import com.elzoz.tickets.mappers.TicketValidationMapper;
import com.elzoz.tickets.services.TicketValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/ticket-validations")
public class TicketValidationController {

    private final TicketValidationService ticketValidationService;
    private final TicketValidationMapper ticketValidationMapper;

    @PostMapping
    public ResponseEntity<TicketValidationResponseDto> validateTicket(
            @RequestBody TicketValidationRequestDto ticketValidationRequestDto
    ){
        TicketValidationMethod method = ticketValidationRequestDto.getValidationMethod();
        TicketValidation ticketValidation;
        if(TicketValidationMethod.MANUAL.equals(method)){
            ticketValidation = ticketValidationService.validateTicketManually(ticketValidationRequestDto.getId());
        }else{
            ticketValidation = ticketValidationService.validateTicketByQrCode(ticketValidationRequestDto.getId());
        }
        return ResponseEntity.ok(
                ticketValidationMapper.toTicketValidationResponseDto(ticketValidation)
        );
    }
}
