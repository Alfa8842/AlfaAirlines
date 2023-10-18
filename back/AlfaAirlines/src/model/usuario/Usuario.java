package model.usuario;

public class Usuario {
	
	//atributos
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private String telefone;
	
	//construtores
	public Usuario(String nome, String email, String cpf, String senha, String telefone) {
		super();
		this.id = -1;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.telefone = telefone;
	}
	
	public Usuario(int id, String nome, String email, String cpf, String senha, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.telefone = telefone;
	}
	
	public Usuario(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toStringSimplificada() {
		String resumo = "Nome: " + this.getNome() + "\n";
		resumo = resumo.concat("E-mail: " + this.getEmail() + "\n");
		resumo = resumo.concat("CPF: " + this.getCpf() + "\n");
		resumo = resumo.concat("Telefone: " + this.getTelefone() + "\n");
		resumo = resumo.concat("-------------------------");
		return resumo;
	}
	
	
	public String toString() {
		String resumo = "ID: " + this.getId() + "\n";
		resumo = resumo.concat("Nome: " + this.getNome() + "\n");
		resumo = resumo.concat("E-mail: " + this.getEmail() + "\n");
		resumo = resumo.concat("CPF: " + this.getCpf() + "\n");
		resumo = resumo.concat("Telefone: " + this.getTelefone() + "\n");
		resumo = resumo.concat("-------------------------");
		return resumo;
	}
}

