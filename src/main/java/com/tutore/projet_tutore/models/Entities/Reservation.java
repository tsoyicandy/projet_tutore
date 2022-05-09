package com.tutore.projet_tutore.models.Entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
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


}
