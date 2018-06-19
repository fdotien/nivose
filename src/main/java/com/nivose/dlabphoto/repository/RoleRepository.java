package com.nivose.dlabphoto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivose.dlabphoto.model.Role;
import com.nivose.dlabphoto.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
