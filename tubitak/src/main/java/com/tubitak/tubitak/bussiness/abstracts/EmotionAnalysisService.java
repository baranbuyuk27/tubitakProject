package com.tubitak.tubitak.bussiness.abstracts;

import com.tubitak.tubitak.models.EmotionAnalysis;

import java.util.List;

public interface EmotionAnalysisService {


    EmotionAnalysis save(EmotionAnalysis emotionAnalysis);

    List<EmotionAnalysis> getByMeetingId(Long meetingId);

    List<EmotionAnalysis> getByUserId(Long userId);

    void delete(Long id);
}
