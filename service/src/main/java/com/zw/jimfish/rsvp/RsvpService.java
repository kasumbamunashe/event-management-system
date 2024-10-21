package com.zw.jimfish.rsvp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RsvpService {
    Rsvp createRsvp(RsvpRequest request);
    Rsvp deleteRsvp(Long id);
    Rsvp findById(Long id);
    Rsvp deleteById(Long id);
    Rsvp updateRsvp(Long id, RsvpRequest request);
    Page<Rsvp> getAll(String searchName, Pageable pageable);
}
