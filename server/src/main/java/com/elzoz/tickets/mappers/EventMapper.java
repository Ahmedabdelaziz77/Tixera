package com.elzoz.tickets.mappers;

import com.elzoz.tickets.domain.CreateEventRequest;
import com.elzoz.tickets.domain.CreateTicketTypeRequest;
import com.elzoz.tickets.domain.dtos.CreateEventRequestDto;
import com.elzoz.tickets.domain.dtos.CreateEventResponseDto;
import com.elzoz.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.elzoz.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);
}
