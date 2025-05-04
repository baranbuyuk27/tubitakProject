package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.MeetingParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingParticipantRepository extends JpaRepository<MeetingParticipant, Long> {
}
