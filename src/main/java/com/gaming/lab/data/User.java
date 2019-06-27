package com.gaming.lab.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Document(collection = "Members")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
//@RequiredArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    @NotBlank(message = "Please make sure you entered your full name")
    private String fullName;

    @Email(message = "Make sure you entered your E-mail right")
    private String email;

    @NotNull
    private String password;

    @NotBlank(message = "Please enter your phone number")
    private String phoneNumber;

    private Gender gender;

    @NotBlank(message = "Please enter your Social Security Number")
    private String ssn;

    @NotBlank(message = "Please specify your work")
    private String work;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bdate;

    private City city;

    private Education education;

    private boolean programmer;

    public User( String fullName,  String email, String password,   String phoneNumber,  Gender gender,  String ssn,  String work, Date bdate,  City city,  Education education, boolean programmer) {
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
