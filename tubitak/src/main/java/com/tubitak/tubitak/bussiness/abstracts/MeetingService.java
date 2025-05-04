package com.tubitak.tubitak.bussiness.abstracts;

import com.tubitak.tubitak.models.Meeting;
import java.util.List;
import java.util.Optional;

public interface MeetingService {
    Meeting save(Meeting meeting);
    List<Meeting> getAll();
    Optional<Meeting> getById(Long id);
    Meeting update(Long id, Meeting meeting);
    void delete(Long id);
}
