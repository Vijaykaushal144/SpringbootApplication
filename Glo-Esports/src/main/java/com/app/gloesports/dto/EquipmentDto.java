package com.app.gloesports.dto;

import com.app.gloesports.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * equipment type should not be null or blank
      * equipment brand should not be null or blank
      * equipment model should not be null or blank
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EquipmentDto {
    private Long eid;
    @NotEmpty(message = "Type is Mandatory")
    private String type;
    @NotEmpty(message = "Brand is Mandatory")
    private String brand;
    @NotEmpty(message ="Model is Mandatory" )
    private String model;

}