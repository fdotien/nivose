package com.nivose.dlabphoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.nivose.dlabphoto.model.User;

/**
 * @author Dotien Joel
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username) throws UsernameNotFoundException;

}
