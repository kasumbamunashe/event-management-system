package com.zw.jimfish.event;

import com.zw.jimfish.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class approveEvent {
    private String notes;
    private Status status;
}
