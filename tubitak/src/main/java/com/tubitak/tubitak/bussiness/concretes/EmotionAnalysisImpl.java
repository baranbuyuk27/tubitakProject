package com.tubitak.tubitak.bussiness.concretes;


import com.tubitak.tubitak.bussiness.abstracts.EmotionAnalysisService;
import com.tubitak.tubitak.core.exceptions.BusinessException;
import com.tubitak.tubitak.models.EmotionAnalysis;
import com.tubitak.tubitak.repositories.EmotionAnalysisRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmotionAnalysisImpl implements EmotionAnalysisService {

    private final EmotionAnalysisRepository emotionAnalysisRepository;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;

    @Override
    public EmotionAnalysis save(EmotionAnalysis emotionAnalysis) {
        return emotionAnalysisRepository.save(modelMapper.map(emotionAnalysis, EmotionAnalysis.class));
    }

    @Override
    public List<EmotionAnalysis> getByMeetingId(Long meetingId) {
        return emotionAnalysisRepository.findByMeetingId(meetingId);
    }

    @Override
    public List<EmotionAnalysis> getByUserId(Long userId) {
        return emotionAnalysisRepository.findByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        EmotionAnalysis emotionAnalysis = emotionAnalysisRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        messageSource.getMessage("emotionAnalysis.notFound", new Object[]{id}, LocaleContextHolder.getLocale())));
        emotionAnalysisRepository.delete(emotionAnalysis);
    }
}
