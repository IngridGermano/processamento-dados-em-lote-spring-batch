package next.cesar.school.Spring_funcionarios.config;

import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.bind.annotation.GetMapping;

import next.cesar.school.Spring_funcionarios.entity.Funcionario;

public class FuncionarioProcessor implements ItemProcessor<Funcionario, Funcionario> {

    @Override
    public Funcionario process(Funcionario item) throws Exception {
        try {
            // Validação do ID
            if (item.getId() == null || item.getId().trim().isEmpty()) {
                System.err.println("Nome inválido, por favor insira um nome válido.");
                return null;
            }
            if (!Pattern.matches("[a-zA-Z ]+", item.getId().trim())) { // Permitindo espaços em branco
                System.err.println("Nome inválido, por favor insira um nome válido.");
                return null;
            }

            // Validação do Salário
            if (item.getSalario() == null || item.getSalario().trim().isEmpty()) {
                System.err.println("Salário inválido, por favor insira um salário válido.");
                return null;
            }
            String salarioSemPontos = removeDots(item.getSalario());
            double salario = Double.parseDouble(salarioSemPontos);
            if (salario < 0) {
                System.err.println("Salário inválido, por favor insira um salário válido.");
                return null;
            }

            // Validação do Ano
            if (item.getAno() == null || item.getAno().trim().isEmpty()) {
                System.err.println("Ano inválido, por favor insira um ano válido.");
                return null;
            }
            double ano = Double.parseDouble(item.getAno());
            if (ano < 0) {
                System.err.println("Ano inválido, por favor insira um ano válido.");
                return null;
            }

            // Validação da Função
            if (item.getFuncao() == null || item.getFuncao().trim().isEmpty()) {
                System.err.println("Nome de função inválida, por favor insira uma função válida.");
                return null;
            }

            System.out.println("Funcionário: " + item);
            return item;

        } catch (NumberFormatException ex) {
            System.err.println("Erro ao formatar número: " + ex.getMessage());
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

    // Método main para teste
    static void RemoverPonto() {
        String salario = "R$ 4.456,23";
        String result = removeDots(salario);
        System.out.println("New String: " + result);
        System.out.println("New Double: " + Double.parseDouble(result.replace(",", "."))); // Convertendo a vírgula para ponto
    }
}


//public class FuncionarioProcessor implements ItemProcessor<Funcionario, Funcionario> {
//
//	@Override
//	public Funcionario process(Funcionario item) throws Exception {
//		
//		    public static void main(String[] args) {
//		        String salario = "R$ 4.456.23";
//		        String result = removeDots(salario);
//		        System.out.println("New String: " + result);
//		        System.out.println("New Double: " + Double.parseDouble(result));
//		    }
//
//		    static String removeDots(String teste) {
//		        String result = "";
//		        boolean dotFound = false;
//		        for (int i = teste.length()-1; i >= 0; i--) {
//		            String temp = String.valueOf(teste.charAt(i));
//		            if (!temp.equals(".")) {
//		                if (!temp.equals("R") && !temp.equals("$") && !temp.equals(" ")) {
//		                    result = temp + result;
//		                }
//		            } else {
//		                if (!dotFound) {
//		                    result = temp + result;
//		                    dotFound = true;
//		                }
//		            }
//		        }
//		        return result;
//		    }
//		}
//	
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
//		System.out.println("Funcionário: " + item);
//		return item;
//		
//		} catch (NumberFormatException ex) {
//			System.err.println("");
//			return null;
//		}
//	}
//}

