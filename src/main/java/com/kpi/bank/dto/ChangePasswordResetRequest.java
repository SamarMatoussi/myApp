package com.kpi.bank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordResetRequest {
    private String newPassword;
    private String confirmationPassword;
}



