package main.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Clientes;

@Repository
public interface IClientesDAO extends JpaRepository<Clientes, String>{

	public Clientes findByNombres(String nombre);
	public boolean existsByNombres(String nombre);

}
