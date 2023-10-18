package model.pacote;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Pacote {
	private int id;
	private String destinos;
	private Double preco;
	private Boolean promocao;
	private Date data;
	private String origem;
	
	public Pacote(int id, String destinos, Double preco, Boolean promocao, Date data, String origem) {
		super();
		this.id = id;
		this.destinos = destinos;
		this.preco = preco;
		this.promocao = promocao;
		this.data = data;
		this.origem = origem;
	}
	
	public Pacote(String destinos, Double preco, Boolean promocao, Date data, String origem) {
		super();
		this.id = -1;
		this.destinos = destinos;
		this.preco = preco;
		this.promocao = promocao;
		this.data = data;
		this.origem = origem;
	}
	
	public Pacote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestinos() {
		return destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(this.data);
		
		return this.id + " - " + this.origem + " -> " + this.destinos + " no dia "
			+ dataFormatada + " promoção: " + this.promocao;
	}
	
}
