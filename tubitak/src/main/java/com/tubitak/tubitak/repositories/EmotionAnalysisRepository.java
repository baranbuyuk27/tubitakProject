package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.EmotionAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmotionAnalysisRepository extends JpaRepository<EmotionAnalysis,Long> {
    List<EmotionAnalysis> findByMeetingId(Long meetingId);
    List<EmotionAnalysis> findByUserId(Long userId);
}
