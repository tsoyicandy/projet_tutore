package com.tutore.projet_tutore.repositories;



import com.tutore.projet_tutore.models.Entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository

public interface MarqueRepository extends JpaRepository<Marque, Integer>  {
}
