package com.elzoz.tickets.mappers;

import com.elzoz.tickets.domain.CreateEventRequest;
import com.elzoz.tickets.domain.CreateTicketTypeRequest;
import com.elzoz.tickets.domain.UpdateEventRequest;
import com.elzoz.tickets.domain.UpdateTicketTypeRequest;
import com.elzoz.tickets.domain.dtos.*;
import com.elzoz.tickets.domain.entities.Event;
import com.elzoz.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventTicketTypeResponseDto toListEventTicketTypeResponseDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

    GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);

    GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType);
}
