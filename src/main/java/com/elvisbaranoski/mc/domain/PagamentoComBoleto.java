package com.elvisbaranoski.mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.elvisbaranoski.mc.domain.enuns.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {
private static final long serialVersionUID = 1L;

//@Temporal(TemporalType.DATE)
private Date dataVencimento;
//@Temporal(TemporalType.DATE)
private Date dataPagamento;

public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento) {
	super(id, estado, pedido);
	this.dataPagamento = dataPagamento;
	this.dataPagamento = dataVencimento;
}


}
