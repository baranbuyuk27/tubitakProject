package com.tubitak.tubitak.bussiness.concretes;

import com.tubitak.tubitak.bussiness.abstracts.RecordingService;
import com.tubitak.tubitak.models.Recording;
import com.tubitak.tubitak.repositories.RecordingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordingServiceImpl implements RecordingService {

    private final RecordingRepository recordingRepository;

    @Override
    public Recording saveRecording(Recording recording) {
        return recordingRepository.save(recording);
    }

    @Override
    public List<Recording> getAllRecordings() {
        return recordingRepository.findAll();
    }

    @Override
    public Optional<Recording> getRecordingById(Long id) {
        return recordingRepository.findById(id);
    }

    @Override
    public Recording updateRecording(Long id, Recording updatedRecording) {
        return recordingRepository.findById(id)
                .map(recording -> {
                    recording.setMeeting(updatedRecording.getMeeting());
                    recording.setRecordingUrl(updatedRecording.getRecordingUrl());
                    recording.setRecordedAt(updatedRecording.getRecordedAt());
                    return recordingRepository.save(recording);
                }).orElseThrow(() -> new RuntimeException("Recording not found"));
    }

    @Override
    public void deleteRecording(Long id) {
        recordingRepository.deleteById(id);
    }
}
