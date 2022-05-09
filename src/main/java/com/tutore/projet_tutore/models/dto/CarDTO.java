package com.tutore.projet_tutore.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private UserDTO user;
    private String immatriculation;
    @ManyToOne
    private MarqueDTO marque;
    @ManyToOne
    private LieuDTO lieu;
    private String etat;
    private String description;
    private Integer prix;
    private String type;
    private String image;
}
