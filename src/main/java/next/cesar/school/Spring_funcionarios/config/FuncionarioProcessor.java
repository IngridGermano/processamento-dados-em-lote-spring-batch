package next.cesar.school.Spring_funcionarios.config;

import org.springframework.batch.item.ItemProcessor;

import next.cesar.school.Spring_funcionarios.entity.Funcionario;

public class FuncionarioProcessor implements ItemProcessor<Funcionario, Funcionario> {

	@Override
	public Funcionario process(Funcionario item) throws Exception {

		// logic

		return item;
	}

}
