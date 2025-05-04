package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
