package com.tutore.projet_tutore.repositories;

import com.tutore.projet_tutore.models.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

}
