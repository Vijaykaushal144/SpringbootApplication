package com.app.gloesports.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * user name should not be null or empty and should have a minimum of 5 characters
      * user email should be a valid email
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class UserDto {
    private Long uid;
    @NotNull
    @Size(min=6,message = "UserName should have minimum 6 characters ")
    private String name;
    @NotNull
     @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$",message = "Enter correct email address of format abc@gmai.com")
    private String email;
    private List<EquipmentDto> equipments;
}