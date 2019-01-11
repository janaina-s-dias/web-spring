package br.com.janainadias.pessoaservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pessoa", schema="janaina")
public class PessoaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PESSOA")
	@SequenceGenerator(name="SEQ_ID_PESSOA", sequenceName="SEQ_ID_PESSOA", allocationSize = 1)
	@Column(name="id_pessoa")
	private Integer codigo;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="fl_ativo")
	private Integer ativo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	
	
	
	
	
}
