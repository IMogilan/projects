package com.mogilan.companymanager.dao.repository.user;

import com.mogilan.companymanager.dao.entity.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
