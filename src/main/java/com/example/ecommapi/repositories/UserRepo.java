package com.example.ecommapi.repositories;

import com.example.ecommapi.entities.Cart;
import com.example.ecommapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    @Query("SELECT u.cart FROM User u WHERE u.id = :userId")
    Cart findCartByUserId(@Param("userId") UUID userId);
}
