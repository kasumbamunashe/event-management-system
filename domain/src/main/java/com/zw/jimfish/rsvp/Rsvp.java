package com.zw.jimfish.rsvp;

import com.zw.jimfish.embedables.Audit;
import com.zw.jimfish.event.Event;
import com.zw.jimfish.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Rsvp")
public class Rsvp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;
    private LocalDateTime rsvpDate;
    @Embedded
    private Audit audit;
}
