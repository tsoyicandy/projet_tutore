package com.tutore.projet_tutore.service;

import com.tutore.projet_tutore.models.dto.ReservationDTO;
import com.tutore.projet_tutore.models.dto.UserDTO;

public interface IReservation {
    int enregistrer_reservation(ReservationDTO reservationdto);
    int ajouter_reservation(ReservationDTO reservationdto);
}
