package com.tubitak.tubitak.bussiness.abstracts;

import com.tubitak.tubitak.models.MeetingParticipant;
import java.util.List;
import java.util.Optional;

public interface MeetingParticipantService {
    MeetingParticipant save(MeetingParticipant participant);
    List<MeetingParticipant> getAll();
    Optional<MeetingParticipant> getById(Long id);
    MeetingParticipant update(Long id, MeetingParticipant participant);
    void delete(Long id);
}
