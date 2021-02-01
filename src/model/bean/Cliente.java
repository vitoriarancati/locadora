package model.bean;

public class Cliente {
	private int idCliente;
	private String cpf;
	private String nomecompleto;
	private int idade;
	private String email;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}//0
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomecompleto() {
		return nomecompleto;
	}
	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}