package com.gaming.lab.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;

@Document(collection = "Members")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@RequiredArgsConstructor
public class User  {

    @Id
    private String id;

    @NotBlank
    private String fullName;

    @Email
    private String email;

    private String password;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private Gender gender;

    @NotBlank
    private String ssn;

    @NotBlank
    private String work;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bdate;

    @NotBlank
    private City city;

    @NotBlank
    private Education education;

    private boolean programmer;

    public User(@NotBlank String fullName, @Email String email, String password, @NotBlank String phoneNumber, @NotBlank Gender gender, @NotBlank String ssn, @NotBlank String work, Date bdate, @NotBlank City city, @NotBlank Education education, boolean programmer) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.ssn = ssn;
        this.work = work;
        this.bdate = bdate;
        this.city = city;
        this.education = education;
        this.programmer = programmer;
    }

    public static enum Gender{
        MALE, FEMALE
    }

    public static enum City{
        AMMAN, ZARQA, AQABA, IRBID, MAAN, KARAK_C, KARAK_M
    }

    public static enum Education{
        UNIVERSITY, SCHOOL, NONE
    }
}
