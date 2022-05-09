package com.tutore.projet_tutore.models.dto;


import com.tutore.projet_tutore.models.Entities.Car;
import com.tutore.projet_tutore.models.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne
    private Car car;
    @ManyToOne
    private User user;
    private String date_debut;
    private String date_fin;
    private Date date;
    private String etat;

    private int idVehicule;
}
