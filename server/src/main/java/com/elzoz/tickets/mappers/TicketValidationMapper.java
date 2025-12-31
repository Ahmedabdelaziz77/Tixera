package com.elzoz.tickets.mappers;

import com.elzoz.tickets.domain.dtos.TicketValidationRequestDto;
import com.elzoz.tickets.domain.dtos.TicketValidationResponseDto;
import com.elzoz.tickets.domain.entities.TicketValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketValidationMapper {

    @Mapping(target = "ticketId", source = "ticket.id")
    TicketValidationResponseDto toTicketValidationResponseDto (TicketValidation ticketValidation);

}
