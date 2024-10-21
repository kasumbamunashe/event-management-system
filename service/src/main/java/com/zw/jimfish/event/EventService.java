package com.zw.jimfish.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {
    Event createEvent(EventRequest request);
    Event findById(Long id);
    Event deleteById(Long id);
    Event  deleteEvent (Long id);
    Event updateEvent(Long id,EventRequest request);
    Page<Event> getAll(String searchName, Pageable pageable);
}
