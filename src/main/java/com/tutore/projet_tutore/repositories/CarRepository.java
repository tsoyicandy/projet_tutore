package com.tutore.projet_tutore.repositories;



import com.tutore.projet_tutore.models.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {




}
