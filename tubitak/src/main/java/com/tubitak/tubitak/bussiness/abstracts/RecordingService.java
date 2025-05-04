package com.tubitak.tubitak.bussiness.abstracts;

import com.tubitak.tubitak.models.Recording;
import java.util.List;
import java.util.Optional;

public interface RecordingService {
    Recording saveRecording(Recording recording);
    List<Recording> getAllRecordings();
    Optional<Recording> getRecordingById(Long id);
    Recording updateRecording(Long id, Recording recording);
    void deleteRecording(Long id);
}
