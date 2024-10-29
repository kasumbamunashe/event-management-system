package com.zw.jimfish.event;

import com.zw.jimfish.embedables.Audit;
import com.zw.jimfish.enums.Status;
import com.zw.jimfish.exceptions.FileDoesNotExistsException;
import jimfish.event.EventRepository;
import jimfish.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Slf4j
@Service
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    @Override
    public Event createEvent(EventRequest request) {
        Event event = Event.builder()
                .name(request.getName())
                .description(request.getName())
                .location(request.getLocation())
                .eventDateTime(request.getEventDateTime())
                .audit(new Audit())
                .status(Status.AWAITING_APPROVAL)
                .build();
        return eventRepository.save(event);
    }
@Override
public Optional<Event> findById(Long id) {
    return eventRepository.findById(id)
            .or(() -> {
                throw new FileDoesNotExistsException("Event not found");
            });
}
    @Override
    public Event deleteById(Long id) {
        Optional <Event>deleteEventOpt = eventRepository.findById(id);

        if (deleteEventOpt.isEmpty()) {
            throw new FileDoesNotExistsException("Invalid Event");
        }
        if (!eventRepository.existsById(id)) {
            throw new FileDoesNotExistsException("Invalid Event");
        }
        Event deleteEvent = deleteEventOpt.get();
        deleteEvent.setStatus(Status.DELETED);
        deleteEvent.setAudit(new Audit());

            return eventRepository.save(deleteEvent);
        }

    @Override
    public Event approveEvent(Long id, approveEvent request) {
        var event = eventRepository.findById(id)
                .orElseThrow(()-> new FileDoesNotExistsException("Event not found"));
        event.setStatus(request.getStatus());
        event.setNotes(request.getNotes());
        event.setAudit(new Audit());
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, EventRequest request) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(()-> new FileDoesNotExistsException("Event not found"+id));
        existingEvent.setName(request.getName());
        existingEvent.setEventDateTime(request.getEventDateTime());
        existingEvent.setStatus(request.getStatus());
        existingEvent.setAudit(new Audit());
        existingEvent.setDescription(request.getDescription());
        existingEvent.setLocation(request.getLocation());
        return eventRepository.save(existingEvent);
    }

    @Override
    public Page<Event> getAll(String searchName, Pageable pageable) {
        if(Objects.nonNull(searchName)){
            eventRepository.findEventByName(searchName,pageable);
        }
        return eventRepository.findAll(pageable);
    }
}
