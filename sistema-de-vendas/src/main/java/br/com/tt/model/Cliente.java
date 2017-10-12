package br.com.tt.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
	@GeneratedValue(generator = "cliente_seq", strategy = GenerationType.AUTO)

	@Column(name = "id_cliente", unique = true)
	private Long id;

	@Column(name = "documento_CPF", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "nome_do_cliente", length = 60)
	private String nome;

	@Column(name = "telefone_Principal", length = 16)
	private String phone_prin;

	@Column(name = "telefone_Opcional", length = 16)
	private String phone_op;

	@Column(length = 45)
	private String email;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nasc")
	private Date dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getPhone_prin() {
		return phone_prin;
	}

	public void setPhone_prin(String phone_prin) {
		this.phone_prin = phone_prin;
	}

	public String getPhone_op() {
		return phone_op;
	}

	public void setPhone_op(String phone_op) {
		this.phone_op = phone_op;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
