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
	public Funcionario(String id, String salario, long ano, String funcao) {
		super();
		this.id = id;
		this.salario = salario;
		this.ano = ano;
		this.funcao = funcao;
	}
	public Funcionario() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public long getAno() {
		return ano;
	}
	public void setAno(long ano) {
		this.ano = ano;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	

}