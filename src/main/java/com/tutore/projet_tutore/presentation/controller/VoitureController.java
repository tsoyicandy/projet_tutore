package com.tutore.projet_tutore.presentation.controller;


import com.tutore.projet_tutore.models.Entities.Car;
import com.tutore.projet_tutore.models.Entities.User;
import com.tutore.projet_tutore.models.dto.CarDTO;
import com.tutore.projet_tutore.models.dto.ReservationDTO;
import com.tutore.projet_tutore.models.dto.UserDTO;
import com.tutore.projet_tutore.repositories.CarRepository;
import com.tutore.projet_tutore.repositories.UserRepository;
import com.tutore.projet_tutore.service.CarService;
import com.tutore.projet_tutore.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class VoitureController {


    @Autowired
    CarService carService;
    @Autowired
    private ReservationService reservationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepository carRepository;

    @GetMapping("/liste_voiture")
    public String listeVoiture(Model model){

        model.addAttribute("cars",carService.listeCar());
        return "listeVoiture";
    }


    @GetMapping("/inscription_page")
    public String inscription(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO",userDTO);
        return "inscription";
    }

    @GetMapping("/ajoutvoiture")
    public String ajoutvoiture(Model model){
        /*CarDTO carDTO = new CarDTO();
        model.addAttribute("carDTO",carDTO);*/
        return "ajoutvoiture";
    }

    @GetMapping("/reserver")
    public String reserver(@RequestParam(value="id")int id, Model model, Principal principal){
        User user =userRepository.findByEmail(principal.getName());

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setIdVehicule(id);

        model.addAttribute("reservationDTO",reservationDTO);
        return "reserver";
    }


    @GetMapping("/liste1")
    public String liste1(){

        return "liste1";
    }



    @GetMapping("/connexion")
    public String connexion(){

        return "connexion";

    }

    @GetMapping("/detail")
    public String detail(){

        return "detail";
    }



}



