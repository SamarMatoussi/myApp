package com.kpi.bank.auth;

import com.kpi.bank.entites.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  @NotBlank
  @Size(max=20)
  private String fullname;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  @NotBlank
  @Size(min=8,max=20)
  private String password;
  private Role role;
}
