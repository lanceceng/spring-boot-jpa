package com.attc.cattail.entity.primary;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true,length = 20)
    private int name;

    @Column(length = 20)
    private int age;

    @Column
    private String classname;


}
