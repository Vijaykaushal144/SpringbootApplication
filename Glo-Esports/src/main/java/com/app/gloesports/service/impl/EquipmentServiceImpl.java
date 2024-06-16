package com.app.gloesports.service.impl;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.EquipmentRepository;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.EquipmentService;
import com.app.gloesports.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// make this into a service layer for Equipment entity

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public EquipmentDto addEquipmentToUser(EquipmentDto equipmentDto, Long userId) {
        // Add equipment to a use
        Equipment equipment = Mapper.mapToEquipmentEntity(equipmentDto);
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User","id",userId);
        }
        User user = optionalUser.get();
        equipment.setUser(user);
        Equipment savedEquipment = equipmentRepository.save(equipment);

        return Mapper.mapToEquipmentDto(savedEquipment);

    }

    @Override
    public EquipmentDto getEquipmentById(Long userId, Long equipmentId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        Optional<Equipment> optionalEquipment=equipmentRepository.findById(equipmentId);
        if(optionalEquipment.isEmpty()){
            throw new ResourceNotFoundException("Equipment","id",equipmentId);
        }
        Equipment equipment=optionalEquipment.get();
        return Mapper.mapToEquipmentDto(equipment);
    }

    @Override
    public EquipmentDto deleteEquipmentById(Long equipmentId, Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new ResourceNotFoundException("user", "id", userId);
        }
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        if (equipment.isEmpty()) {
            throw new ResourceNotFoundException("equipment", "id", equipmentId);
        }
        equipmentRepository.deleteById(equipmentId);
        Equipment equipmen=equipment.get();

        return Mapper.mapToEquipmentDto(equipmen);
    }
}
