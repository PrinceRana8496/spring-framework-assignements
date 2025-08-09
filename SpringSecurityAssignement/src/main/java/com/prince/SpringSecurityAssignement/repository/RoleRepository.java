package com.prince.SpringSecurityAssignement.repository;

import com.prince.SpringSecurityAssignement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}