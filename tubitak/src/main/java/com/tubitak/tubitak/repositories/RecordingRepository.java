package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.Recording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingRepository extends JpaRepository<Recording, Long> {
}
