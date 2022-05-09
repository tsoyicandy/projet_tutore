package com.tutore.projet_tutore.controller;




import com.tutore.projet_tutore.models.Entities.User;
import com.tutore.projet_tutore.models.dto.UserDTO;
import com.tutore.projet_tutore.repositories.UserRepository;
import com.tutore.projet_tutore.service.IUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

   // IUserImpl iUserImpl;

    @Autowired
    private IUserImpl iUser;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @GetMapping("/inscription")
    public String ajouterUser(Model model){

        UserDTO userDTO = new UserDTO();
        userDTO.setNom("test");
        model.addAttribute("userDTO",userDTO);

        return "inscription";
    }

    @PostMapping("enregistreruser")
    public String enregistrerUser(@ModelAttribute UserDTO userDto, Model model){
        // appel de la couche service ou metier injectée pour enregistrer un produit
        iUser.ajouterUser(userDto);

        return "redirect:/";
    }


    @GetMapping("/creer")
    public String saveU(){
       
        User user= new User("aure@gmail.com",encoder.encode("aure"));


        return "redirect:/";
    }



}
