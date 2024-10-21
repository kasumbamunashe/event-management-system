package com.zw.jimfish.event;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
@Tag(name = "Classes", description = "Create, Read, Update and Delete classes")
@CrossOrigin

public class Event {
    @GetMapping("/event")
    public String index() {
        return "event";
    }
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
}
