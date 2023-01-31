package com.example.enesbaskale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;
    @NotEmpty(message = "Ad Soyad alanı boş geçemezsiniz!")
    @Size(min = 1, max = 255)
    private String teacherNameSurname;
    @NotEmpty(message = "Email alanını boş geçemezsiniz!")
    @Email(message = "Uygun formatta mail adresi girmediniz")
    private String teacherEmail;
    @NotEmpty(message = "Şifre alanını boş geçemezsiniz!")
    @Size(min = 10, max = 18)
    private String teacherPassword;

}
