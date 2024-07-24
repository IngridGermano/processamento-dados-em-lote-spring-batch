package next.cesar.school.Spring_funcionarios;

public class FuncionarioProcessParam {

	public static String arquivoCsv = "";
	private String[] params;
			
	public FuncionarioProcessParam(String[] params) {
		this.setParams(params);
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	
}
