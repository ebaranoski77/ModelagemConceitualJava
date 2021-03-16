package com.elvisbaranoski.mc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@AllArgsConstructor@Getter*/
@Setter
@NoArgsConstructor
@Entity
public class Pedido implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

//@Temporal(TemporalType.TIMESTAMP)
private Date instante;

@OneToOne(cascade = CascadeType.ALL, mappedBy="pedido")
private Pagamento pagamento;

@ManyToOne
@JoinColumn(name="cliente_id")//chave estrangeira
private Cliente cliente;

@ManyToOne
@JoinColumn(name="endereco_de_entrega_id")
private Endereco enderecoDeEntrega;

public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
	super();
	this.id = id;
	this.instante = instante;
	this.cliente = cliente;
	this.enderecoDeEntrega = enderecoDeEntrega;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pedido other = (Pedido) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}




}
