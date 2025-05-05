package com.tubitak.tubitak.bussiness.abstracts;

import com.tubitak.tubitak.models.FocusTracking;

import java.util.List;

public interface FocusTrackingService {

    FocusTracking save(FocusTracking focusTracking);
    List<FocusTracking> getByMeetingId(Long meetingId);
    List<FocusTracking> getByUserId(Long userId);
    void delete(Long id);
}
