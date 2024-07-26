package next.cesar.school.Spring_funcionarios.config;

import java.util.regex.Pattern;

import java.lang.NumberFormatException;

import org.springframework.batch.item.ItemProcessor;

import next.cesar.school.Spring_funcionarios.entity.Funcionario;

public class FuncionarioProcessor implements ItemProcessor<Funcionario, Funcionario> {
	 
	
	
    @Override
    public Funcionario process(Funcionario item) throws Exception {

	
        try {
            if (item.getId() == null || item.getId().trim().equals("")) {
                System.err.println("Nome inválido, por favor insira um nome válido.");
                return null;
            }
           if (!Pattern.matches("[a-zA-Z- ÁáÉéÍíÓóÚú ÂâÊêÔô ÃãÕõ Çç ]+", item.getId().trim())) {
              System.err.println("Nome inválido, por favor insira um nome válido.");
              return null;
           }
            if (item.getSalario() == null || item.getSalario().trim().equals("")) {
               System.err.println("Salário inválido, por favor insira um salário válido.");
              return null;
           }
            String salarioSemPontos = removeDots(item.getSalario());
            double salario = Double.parseDouble(salarioSemPontos);
            if (salario < 0) {
                System.err.println("Salário inválido, por favor insira um salário válido.");
                return null;
            }
           if (item.getAno() == null || Double.parseDouble(item.getAno()) < 0) {
              System.err.println("Ano inválido, por favor insira um ano válido.");
              return null;
            }
            if (item.getFuncao() == null || item.getFuncao().trim().equals("")) {
                System.err.println("Nome de função inválida, por favor insira uma função válida.");
                return null;
            }
            System.out.println("Funcionário: " + item);
            return item;

        } catch (NumberFormatException ex) {
            System.err.println("Erro de formato de número: " + ex.getMessage());
            return null;
        }
    }
    static String removeDots(String teste) {
        String result = "";
        boolean dotFound = false;
        for (int i = teste.length() - 1; i >= 0; i--) {
            String temp = String.valueOf(teste.charAt(i));
            if (!temp.equals(".")) {
                if (!temp.equals("R") && !temp.equals("$") && !temp.equals(" ")) {
                    result = temp + result;
                }
            } else {
                if (!dotFound) {
                    result = temp + result;
                    dotFound = true;
                }
            }
        }
        return result;
    }
}

