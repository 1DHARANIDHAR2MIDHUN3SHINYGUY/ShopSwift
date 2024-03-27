package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface Repo extends JpaRepository<Model,Integer>{
	
	@Query(value= "Select p.* , (p.quantity * p.price) as t_amt from e_commerce p",nativeQuery = true)
	List<Model> findAllWithTotal();
	
}
