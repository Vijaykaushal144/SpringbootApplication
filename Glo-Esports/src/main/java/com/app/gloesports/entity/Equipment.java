package com.app.gloesports.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    /*
        task is to add a new column type of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false,unique = true)
    private String type;
    /*
        task is to add a new column brand of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false,unique = true)
    private String brand;
    /*
        task is to add a new column model of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false,unique = true)
    private String model;

    /*
        task is to establish the mapping between User and Equipment
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
