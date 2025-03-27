package com.geruser.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //gera automaticamente os métodos getters e setters, evitando a necessidade de escreve-los manualmente
@NoArgsConstructor //Cria um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos
@Entity //Define que essa classe representa uma entidade JPA, ou seja, um mapeamento para uma tabela no banco de dados
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Define que o campo id será gerado automaticamente pelo banco de dados, normalmente como um auto incremento
	private Long id;
	
	@NotNull //garante que o campo não pode ser nulo
	@NotBlank //garante que o campo não pode ser vazio ou conter espaços em branco
	private String nome;
	
	@NotNull
	@NotBlank
	@Email(message = "Informe o e-mail corretamente")
	private String email;

}
