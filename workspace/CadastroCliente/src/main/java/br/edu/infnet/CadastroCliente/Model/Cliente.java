package br.edu.infnet.CadastroCliente.Model;




import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente {

	
	@Column(name = "nome")
	@Size(min = 6)
	private String nome;
	
	@Id
	@Size(min = 11,max = 18)
	@Column(name = "cpfCnpj")
	private String cpfCnpj;
	
	@Column(name = "email")
	@Email(message = "O email tem que ser valido")
	private String email;
	
	@Column(name = "telefone")
	@Size(max = 9)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
	
}
