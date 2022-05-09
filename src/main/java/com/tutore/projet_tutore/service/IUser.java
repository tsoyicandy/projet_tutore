package com.tutore.projet_tutore.service;




import com.tutore.projet_tutore.models.dto.UserDTO;
import com.tutore.projet_tutore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface IUser {


     int ajouterUser( UserDTO userDTO );

     int enregistrerUser(UserDTO userdto);


}
