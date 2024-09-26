package com.backend.MayurBhilareBackend.Repository;

import com.backend.MayurBhilareBackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);

}
