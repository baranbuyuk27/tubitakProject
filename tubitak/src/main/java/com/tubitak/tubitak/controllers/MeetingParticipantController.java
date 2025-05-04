package com.tubitak.tubitak.controllers;

import com.tubitak.tubitak.bussiness.abstracts.MeetingParticipantService;
import com.tubitak.tubitak.models.MeetingParticipant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meeting-participants")
@RequiredArgsConstructor
public class MeetingParticipantController {

    private final MeetingParticipantService participantService;

    @PostMapping
    public ResponseEntity<MeetingParticipant> create(@RequestBody MeetingParticipant participant) {
        return ResponseEntity.ok(participantService.save(participant));
    }

    @GetMapping
    public ResponseEntity<List<MeetingParticipant>> getAll() {
        return ResponseEntity.ok(participantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeetingParticipant> getById(@PathVariable Long id) {
        return participantService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeetingParticipant> update(@PathVariable Long id, @RequestBody MeetingParticipant participant) {
        return ResponseEntity.ok(participantService.update(id, participant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        participantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
