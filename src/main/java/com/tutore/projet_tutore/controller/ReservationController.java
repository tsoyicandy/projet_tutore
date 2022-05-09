package com.tutore.projet_tutore.controller;


import com.tutore.projet_tutore.models.Entities.Car;
import com.tutore.projet_tutore.models.Entities.User;
import com.tutore.projet_tutore.models.dto.ReservationDTO;
import com.tutore.projet_tutore.repositories.CarRepository;
import com.tutore.projet_tutore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tutore.projet_tutore.service.ReservationService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.Instant;
import java.util.Date;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    @GetMapping("/liste_reservation")
    public String liste_reservation(Model model){

        model.addAttribute("listReservation",reservationService.getAllReservation());

        return "liste_reservations";
    }

    @GetMapping("/mes_reservations")
    public String mes_reservations(Model model){

        model.addAttribute("listReservation",reservationService.getAllReservation());

        return "profil";
    }

    @GetMapping("/reserve")
    public String ajouter_reservation(@RequestParam(value="id")int id, Model model){



        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setEtat("En attente");
        reservationDTO.setDate(Date.from(Instant.now()));
        model.addAttribute("reservationDTO",reservationDTO);

        return "profil";
    }

    @PostMapping("/enregistrer_reservation")
    public String enregistrer_reservation(@ModelAttribute ReservationDTO reservationDTO,Principal principal){

        User user =userRepository.findByEmail(principal.getName());

        Car car = carRepository.getById(reservationDTO.getIdVehicule());
        reservationDTO.setEtat("En attente");
        reservationDTO.setDate(Date.from(Instant.now()));
        reservationDTO.setUser(user);
        reservationDTO.setCar(car);

        reservationService.ajouter_reservation(reservationDTO);
        return "redirect:/";
    }
    /*@GetMapping("/supprimermateriel")
    public String supprimerMateriel(@RequestParam(name="etreservation") String etreservation, Model model) {



        // appel de la methode de la couche service qui supprime un objet materiel en fonction de la ref


        iMateriel.supprimerMateriel(refmateriel);
        return "redirect:/listermateriels";
    }
  */

}
