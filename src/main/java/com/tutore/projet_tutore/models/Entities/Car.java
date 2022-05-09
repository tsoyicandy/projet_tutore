package com.tutore.projet_tutore.models.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private User user;
    private String immatriculation;
    @ManyToOne
    private Marque marque;
    @ManyToOne
    private Lieu lieu;
    private String etat;
    private String description;
    private Integer prix;
    private String type;
    private String image;


}
