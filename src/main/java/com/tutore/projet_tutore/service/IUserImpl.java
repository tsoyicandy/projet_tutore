package com.tutore.projet_tutore.service;


import com.tutore.projet_tutore.models.Entities.User;
import com.tutore.projet_tutore.models.dto.UserDTO;
import com.tutore.projet_tutore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IUserImpl implements IUser {
    @Autowired
    UserRepository userRepository;

    IUser iuser;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private ModelMapper mapper  = new ModelMapper();

    @Override
    public int ajouterUser(UserDTO userDTO) {

        System.out.println("pass*********************:"+userDTO.getMotdepasse());
        userDTO.setMotdepasse(encoder.encode(userDTO.getMotdepasse()));
        userRepository.save(mapper.map(userDTO,User.class));

      return  1;

    }


    @Override
    public int enregistrerUser( UserDTO userdto) {

        // appel de la couche service ou metier injectée pour enregistrer un produit
        iuser.ajouterUser(userdto);

        return 1;
    }



}
