package com.project.test.springbootlesson1.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Prduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Model;
    private int price;
}
