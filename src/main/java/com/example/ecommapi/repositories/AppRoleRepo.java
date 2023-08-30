package com.example.ecommapi.repositories;

import com.example.ecommapi.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, String> {
}
