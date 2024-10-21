package com.zw.jimfish.rsvp;

import com.zw.jimfish.event.Event;
import com.zw.jimfish.user.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RsvpRequest {
    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;
    private LocalDateTime rsvpDate;
}
