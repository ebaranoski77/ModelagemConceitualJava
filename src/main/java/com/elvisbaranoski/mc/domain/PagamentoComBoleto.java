package com.elvisbaranoski.mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.elvisbaranoski.mc.domain.enuns.EstadoPagamento;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	//@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	//@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataPagamento = dataVencimento;
	}


}
