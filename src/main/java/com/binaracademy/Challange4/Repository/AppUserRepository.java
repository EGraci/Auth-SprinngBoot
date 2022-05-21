package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Modifying
    @Query(value = "UPDATE user SET email = :email, password = :password, username = :username WHERE id_user = :id", nativeQuery = true)
    public void update_id(@Param("id") Long id, @Param("username") String username, @Param("email") String email, @Param("password") String password);

    public boolean existsByUsername(String username);

    public AppUser findByUsername(String username);
}
