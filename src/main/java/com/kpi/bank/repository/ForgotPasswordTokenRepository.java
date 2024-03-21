package com.kpi.bank.repository;

import com.kpi.bank.entites.ForgotPasswordToken;
import com.kpi.bank.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface ForgotPasswordTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {
    @Query("select fpt from ForgotPasswordToken fpt where fpt.token = ?1 and fpt.user = ?2 ")
    Optional<ForgotPasswordToken> findByTokenAndUser(Integer token, User user);
}
