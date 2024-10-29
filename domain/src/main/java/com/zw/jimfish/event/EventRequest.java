package com.zw.jimfish.event;

import com.zw.jimfish.enums.Status;
import com.zw.jimfish.user.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRequest {
    private String name;
    private String description;
    private String location;
    private LocalDateTime eventDateTime;
    private Status status;
}
