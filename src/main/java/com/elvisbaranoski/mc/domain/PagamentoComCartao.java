package com.elvisbaranoski.mc.domain;

import javax.persistence.Entity;

import com.elvisbaranoski.mc.domain.enuns.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L; 

	private Integer numeroDeParcelas;
	public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;

	}



}
