package next.cesar.school.Spring_funcionarios.config;

import java.util.regex.Pattern;

import java.lang.NumberFormatException;

import org.springframework.batch.item.ItemProcessor;

import next.cesar.school.Spring_funcionarios.entity.Funcionario;

public class FuncionarioProcessor implements ItemProcessor<Funcionario, Funcionario> {

	@Override
	public Funcionario process(Funcionario item) throws Exception {

//		try {
//		if (item.getId().trim() == "") {
//		System.err.println("Nome inválido, por favor insira um nome válido.");
//		return null;
//		}
//		if (!Pattern.matches("[a-zA-Z]+", item.getId().trim())) {
//			System.err.println("Nome inválido, por favor insira um nome válido.");
//			return null;
//		}
//		if (Double.parseDouble(item.getSalario()) < 0 || item.getSalario() == null) {
//			System.err.println("Salário inválido, por favor insira um salário válido.");
//			return null;
//		}
//		if (Double.parseDouble(item.getAno()) < 0 || item.getAno() == null) {
//			System.err.println("Ano inválido, por favor insira um ano válido.");
//			return null;
//		}
//		if (item.getFuncao().trim() == "") {
//			System.err.println("Nome de função inválida, por favor insira uma função válida.");
//			return null;
//		}
		System.out.println("Funcionário: " + item);
		return item;
//		
//		} catch (NumberFormatException ex) {
//			System.err.println("");
//			return null;
//		}
	}
}
