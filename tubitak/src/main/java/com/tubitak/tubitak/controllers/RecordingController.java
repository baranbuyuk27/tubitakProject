package com.tubitak.tubitak.controllers;

import com.tubitak.tubitak.bussiness.abstracts.RecordingService;
import com.tubitak.tubitak.models.Recording;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recordings")
@RequiredArgsConstructor
public class RecordingController {

    private final RecordingService recordingService;

    @PostMapping
    public ResponseEntity<Recording> createRecording(@RequestBody Recording recording) {
        return ResponseEntity.ok(recordingService.saveRecording(recording));
    }

    @GetMapping
    public ResponseEntity<List<Recording>> getAllRecordings() {
        return ResponseEntity.ok(recordingService.getAllRecordings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recording> getRecordingById(@PathVariable Long id) {
        return recordingService.getRecordingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recording> updateRecording(@PathVariable Long id, @RequestBody Recording recording) {
        return ResponseEntity.ok(recordingService.updateRecording(id, recording));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecording(@PathVariable Long id) {
        recordingService.deleteRecording(id);
        return ResponseEntity.noContent().build();
    }
}
