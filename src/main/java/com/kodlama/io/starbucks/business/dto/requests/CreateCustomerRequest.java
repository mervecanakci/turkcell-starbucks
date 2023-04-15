package com.kodlama.io.starbucks.business.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    @NotBlank(message = "İsim boş bırakılamaz.")
    private String firstName;
    @NotBlank(message = "Soyisim boş bırakılamaz.")
    private String lastName;

    @NotNull
    private LocalDate dateOfBirth;
    @NotBlank(message = "TC kimlik boş bırakılamaz.")
    @Length(min = 11, max =11, message = "TC kimlik numarası 11 haneden oluşmak zorunda.")
    private String nationalIdentity;
}





