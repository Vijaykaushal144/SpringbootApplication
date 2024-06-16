package com.app.gloesports.controller;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.entity.User;
import com.app.gloesports.service.impl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


// It is a controller class that handle
// s the equipment related requests
@RestController
public class EquipmentController {

    // Add equipment to a user

    @Autowired
    EquipmentServiceImpl equipmentservice;

    @PostMapping("/addEquipment/{userId}")
    public EquipmentDto addEquipmentToUser(@Validated @RequestBody EquipmentDto equipmentDto,
                                           @PathVariable Long userId) {
        return equipmentservice.addEquipmentToUser(equipmentDto, userId);
    }

    // Get equipment by equipmentId
    @GetMapping("/getEquipmentById/{userId}/{equipmentId}")
    public EquipmentDto getEquipmentById(@PathVariable Long userId, @PathVariable Long equipmentId) {
        return equipmentservice.getEquipmentById(userId, equipmentId);
    }

    // Delete equipment from a User by equipmentId
    @DeleteMapping("/deleteEquipmentById/{equipmentId}/{userId}")
    public EquipmentDto deleteEquipmentById(@PathVariable Long equipmentId, @PathVariable Long userId) {
        return equipmentservice.deleteEquipmentById(equipmentId, userId);
    }

}
