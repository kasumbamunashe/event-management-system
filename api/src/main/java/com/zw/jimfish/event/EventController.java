package com.zw.jimfish.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
@Tag(name = "Event", description = "Event")
@CrossOrigin
public class EventController {
    private final EventService eventService;
    @PostMapping("/create")
    @Operation(description = "create event")
    ResponseEntity<Event>create(@RequestBody EventRequest request){
        return ResponseEntity.ok(eventService.createEvent(request));
    }
    @PutMapping("/{id}")
    @Operation(description = "update event")
    ResponseEntity<Event>update(@PathVariable Long id,@RequestBody EventRequest request){
        return ResponseEntity.ok(eventService.updateEvent(id,request));
    }
    @GetMapping("/{id}")
    @Operation(description = "get events byId")
    Optional<Event> getById(@PathVariable Long id){
        return eventService.findById(id);
    }
    @GetMapping("/getll")
    @Operation(description = "getAll events")
    ResponseEntity<Page<Event>>getAll(@Nullable String name, Pageable pageable){
        return ResponseEntity.ok(eventService.getAll(name,pageable));
    }
    @DeleteMapping("/{id}")
    @Operation(description = "delete byId")
    ResponseEntity<Event>deleteById(@PathVariable Long id){
        return ResponseEntity.ok(eventService.deleteById(id));
    }

}
