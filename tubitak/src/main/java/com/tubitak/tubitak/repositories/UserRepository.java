package com.tubitak.tubitak.repositories;

import com.tubitak.tubitak.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
