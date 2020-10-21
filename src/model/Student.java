package model;

public class Student {

	private Long matricula;
	private String nome;
	private char sexo;
	private String endereco;
	
	public Student(Long matricula, String nome, char sexo, String endereco) {
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return System.lineSeparator()+"Nome: "+nome
		 +" ||   Sexo: "+sexo
		 +System.lineSeparator()+"Matricula: "+matricula
		 +System.lineSeparator()+"Endereço: "+endereco
		 +System.lineSeparator();
	}
	
	
}
