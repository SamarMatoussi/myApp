package com.kpi.bank.controller;

import com.kpi.bank.dto.ChangePasswordResetRequest;
import com.kpi.bank.entites.User;
import com.kpi.bank.services.PasswordResetTokenService;
import com.kpi.bank.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final PasswordResetTokenService passwordResetTokenService;



    @GetMapping("/{email}")
    public User fetchUser(@PathVariable String email) {

        return service.fetchUser(email);
    }


    //send mail for email verification
    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> verifyEmail(@PathVariable String email){

        return passwordResetTokenService.verifyEmail(email);

    }


    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp,@PathVariable String email){
        return passwordResetTokenService.verifyOtp(otp, email);
    }

    //Now User Can change the password

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePasswordHandler(
            @RequestBody ChangePasswordResetRequest changePassword,
            @PathVariable String email
    ){
        return passwordResetTokenService.changePasswordHandler(changePassword,email);
    }


}
