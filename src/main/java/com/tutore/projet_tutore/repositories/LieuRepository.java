package com.tutore.projet_tutore.repositories;



import com.tutore.projet_tutore.models.Entities.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer>{
}
