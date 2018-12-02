package com.attc.cattail.entity.secondary;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true,length = 20)
    private int name;

    @Column(length = 20)
    private int age;

    @Column
    private String subject;
}
