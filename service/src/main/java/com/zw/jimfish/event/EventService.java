package com.zw.jimfish.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EventService {
    Event createEvent(EventRequest request);
   Optional <Event> findById(Long id);
   Event deleteById(Long id);
   Event approveEvent(Long id, approveEvent request);

    Event updateEvent(Long id,EventRequest request);
    Page<Event> getAll(String searchName, Pageable pageable);
}
