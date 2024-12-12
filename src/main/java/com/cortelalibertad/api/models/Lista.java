package com.cortelalibertad.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listas")
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String codigo;
	String nombre;
	String titular;
}
