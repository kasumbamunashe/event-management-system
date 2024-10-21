package com.zw.jimfish.event;

import com.zw.jimfish.embedables.Audit;
import com.zw.jimfish.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location; // Use for Google Maps integration
    private LocalDateTime eventDateTime;
    @ManyToOne
    private User organizer;
    @ManyToMany
    private List<User> attendees;
    @Embedded
    private Audit audit;
}
