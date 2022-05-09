package com.tutore.projet_tutore.service;



import com.tutore.projet_tutore.models.Entities.Reservation;
import com.tutore.projet_tutore.models.dto.CarDTO;
import com.tutore.projet_tutore.models.dto.UserDTO;
import com.tutore.projet_tutore.repositories.ReservationRepository;
import com.tutore.projet_tutore.models.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements IReservation {

    @Autowired
    private ReservationRepository reservationRepository;

    IReservation ireservation;
    private ModelMapper mapper  = new ModelMapper();


    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    @Override
    public int ajouter_reservation(ReservationDTO reservationDTO) {

        // System.out.println("pass*********************:"+userDTO.getMotdepasse());
        reservationDTO.setEtat("En attente");
        //reservationDTO.setDate(""+Date.from(Instant.now()));
        /*reservationDTO.setCar(CarDTO car);
        reservationDTO.setUser(UserDTO user);*/
        reservationRepository.save(mapper.map(reservationDTO,Reservation.class));

        return  1;

    }

    @Override
    public int enregistrer_reservation( ReservationDTO reservationDTO) {

        // appel de la couche service ou metier injectée pour enregistrer un produit
        ireservation.ajouter_reservation(reservationDTO);

        return 1;
    }


}
