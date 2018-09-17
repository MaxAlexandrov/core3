package com.exchanger.repository;

import com.exchanger.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByrole(String role);
}
