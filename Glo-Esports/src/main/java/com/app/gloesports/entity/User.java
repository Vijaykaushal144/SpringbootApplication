package com.app.gloesports.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    /*
        task is to add a new column name of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private String name;
    /*
        task is to add a new column email of type String.
        It should not be null.
        It should be unique.
        Use appropriate annotation.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /*
        task is to establish the mapping between User and Equipment
        it should be a appropriate mapping as per the diagram
     */

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Equipment> equipments;



}


