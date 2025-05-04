package com.tubitak.tubitak.bussiness.concretes;

import com.tubitak.tubitak.bussiness.abstracts.MeetingParticipantService;
import com.tubitak.tubitak.models.MeetingParticipant;
import com.tubitak.tubitak.repositories.MeetingParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingParticipantServiceImpl implements MeetingParticipantService {

    private final MeetingParticipantRepository participantRepository;

    @Override
    public MeetingParticipant save(MeetingParticipant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<MeetingParticipant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public Optional<MeetingParticipant> getById(Long id) {
        return participantRepository.findById(id);
    }

    @Override
    public MeetingParticipant update(Long id, MeetingParticipant updatedParticipant) {
        return participantRepository.findById(id)
                .map(participant -> {
                    participant.setMeeting(updatedParticipant.getMeeting());
                    participant.setUser(updatedParticipant.getUser());
                    participant.setJoinTime(updatedParticipant.getJoinTime());
                    participant.setLeaveTime(updatedParticipant.getLeaveTime());
                    return participantRepository.save(participant);
                }).orElseThrow(() -> new RuntimeException("MeetingParticipant not found"));
    }

    @Override
    public void delete(Long id) {
        participantRepository.deleteById(id);
    }
}
