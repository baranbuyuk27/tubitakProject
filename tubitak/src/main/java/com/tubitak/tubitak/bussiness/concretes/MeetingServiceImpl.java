package com.tubitak.tubitak.bussiness.concretes;

import com.tubitak.tubitak.bussiness.abstracts.MeetingService;
import com.tubitak.tubitak.models.Meeting;
import com.tubitak.tubitak.repositories.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    @Override
    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getById(Long id) {
        return meetingRepository.findById(id);
    }

    @Override
    public Meeting update(Long id, Meeting updatedMeeting) {
        return meetingRepository.findById(id)
                .map(meeting -> {
                    meeting.setMeetingCode(updatedMeeting.getMeetingCode());
                    meeting.setStartTime(updatedMeeting.getStartTime());
                    meeting.setEndTime(updatedMeeting.getEndTime());
                    meeting.setStatus(updatedMeeting.getStatus());
                    meeting.setCreatedBy(updatedMeeting.getCreatedBy());
                    return meetingRepository.save(meeting);
                }).orElseThrow(() -> new RuntimeException("Meeting not found"));
    }

    @Override
    public void delete(Long id) {
        meetingRepository.deleteById(id);
    }
}
