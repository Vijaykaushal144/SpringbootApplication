package com.app.gloesports.repository;

import com.app.gloesports.entity.Equipment;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// make this into a equipment repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {

}
