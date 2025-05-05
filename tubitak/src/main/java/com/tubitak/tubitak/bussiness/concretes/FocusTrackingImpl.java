package com.tubitak.tubitak.bussiness.concretes;

import com.tubitak.tubitak.bussiness.abstracts.FocusTrackingService;
import com.tubitak.tubitak.core.configuration.MessageSourceConfiguration;
import com.tubitak.tubitak.core.configuration.ModelMapperConfiguration;
import com.tubitak.tubitak.core.exceptions.BusinessException;
import com.tubitak.tubitak.models.FocusTracking;
import com.tubitak.tubitak.repositories.FocusTrackingRepository;
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
public class FocusTrackingImpl implements FocusTrackingService {

    private final FocusTrackingRepository focusTrackingRepository;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;


    @Override
    public FocusTracking save(FocusTracking focusTracking) {
        return focusTrackingRepository.save(modelMapper.map(focusTracking, FocusTracking.class));
    }

    @Override
    public List<FocusTracking> getByMeetingId(Long meetingId) {
        return focusTrackingRepository.findByMeetingId(meetingId);
    }

    @Override
    public List<FocusTracking> getByUserId(Long userId) {
        return focusTrackingRepository.findByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        FocusTracking focusTracking = focusTrackingRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        messageSource.getMessage("focusTracking.notFound", new Object[]{id}, LocaleContextHolder.getLocale())));
        focusTrackingRepository.delete(focusTracking);
    }
}
