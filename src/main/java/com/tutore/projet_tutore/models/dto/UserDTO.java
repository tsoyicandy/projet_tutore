package com.tutore.projet_tutore.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data//pour generer les getters et setters automatiquement avec lomnbok
@NoArgsConstructor// pour generer le constructeur par defaut
@AllArgsConstructor// pour generer tous les constructeur
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero;
    private String motdepasse;

}
