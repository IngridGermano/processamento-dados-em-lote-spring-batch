package next.cesar.school.Spring_funcionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	//	FuncionarioProcessParam processParams = new FuncionarioProcessParam(args);
		String arquivoCsv = "src/main/resources/funcionarios.csv";
		
		if (args.length == 1) {
			if (args[0].equals("-v")) {
				System.out.println("Versão 1.0.0");
				System.exit(0);
			} else if (args[0].equals("--help") || args[0].equals("-h")) {
				System.out.println("--Menu de ajuda--"); // passar aqui as instruções de ajuda
				System.out.println("Para acessar o banco de dados procure a opção "
						+ "Run na aba superior da sua IDE. \nApós isso procure a opção "
						+ "Run Configuration, clique em arguments e, dentro do program arguments,\n"
						+ "insira entre aspas o caminho do arquivo csv a ser lido.");
				System.exit(0);
			} else {
				arquivoCsv = args[0];
			}
		}
		FuncionarioProcessParam.arquivoCsv = arquivoCsv;
		SpringApplication.run(Application.class, args);
	}
}
