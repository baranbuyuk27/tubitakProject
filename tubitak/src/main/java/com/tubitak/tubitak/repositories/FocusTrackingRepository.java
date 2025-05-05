package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.FocusTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FocusTrackingRepository extends JpaRepository<FocusTracking,Long> {
    List<FocusTracking> findByMeetingId(Long meetingId);
    List<FocusTracking> findByUserId(Long userId);
}
