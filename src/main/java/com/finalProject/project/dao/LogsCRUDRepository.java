package com.finalProject.project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.finalProject.project.entity.Log;

public interface LogsCRUDRepository extends CrudRepository<Log, Integer> {

	// Crear una API Rest propia

	// @Query(value = "SELECT * from Logs where year=:anio and month=:mes",
	// nativeQuery = true)

	// En el leguaje JPAQL el Log es el objeto
	@Query("from Log a where a.month=:mes and a.year=:anio")
	public Iterable<Log> getAccessByAnioAndMes(int anio, int mes);

	@Query("from Log a where a.month=:mes and a.year=:anio and a.employee.nombre=:nombre")
	public Iterable<Log> getAccessByAnioAndMesAndName(int anio, int mes, String nombre);

	@Query("from Log a where a.month=:mes and a.year>=:anioOrigen and a.year<=:anioFinal and a.employee.nombre=:nombre")
	public Iterable<Log> getAccessByAnioAndMesAndName(int anioOrigen, int anioFinal, int mes, String nombre);

}