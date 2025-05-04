package com.tubitak.tubitak.controllers;

import com.tubitak.tubitak.bussiness.abstracts.MeetingService;
import com.tubitak.tubitak.models.Meeting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public ResponseEntity<Meeting> create(@RequestBody Meeting meeting) {
        return ResponseEntity.ok(meetingService.save(meeting));
    }

    @GetMapping
    public ResponseEntity<List<Meeting>> getAll() {
        return ResponseEntity.ok(meetingService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getById(@PathVariable Long id) {
        return meetingService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> update(@PathVariable Long id, @RequestBody Meeting meeting) {
        return ResponseEntity.ok(meetingService.update(id, meeting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        meetingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
