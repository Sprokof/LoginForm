package com.login.form.repository;

import com.login.form.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
