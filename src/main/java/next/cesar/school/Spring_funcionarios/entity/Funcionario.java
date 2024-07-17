package next.cesar.school.Spring_funcionarios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FUNCIONARIOS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

	@Id
	@Column(name = "Nome")
	private String id;
	@Column(name = "Salario")
	private String salario;
	@Column(name = "Ano_de_admissao")
	private long ano;
	@Column(name = "Funcao_do_Funcionario")
	private String funcao;
	
		
	

}