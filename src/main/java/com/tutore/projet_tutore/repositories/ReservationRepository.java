package com.tutore.projet_tutore.repositories;



import com.tutore.projet_tutore.models.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>  {

   /* Integer deleteReservationByEtat(String id);
    @Modifying
    @Query("delete from Reservation r where r.etat=:etat")
    void deleteReservation(@Param("etat") String etat);

    Optional<Reservation> findReservationByEtat(String etat);

    List<Reservation> findReservationByEtatOrUserOrCar(String motcle, String motcle1, String motcle2);
*/
}
