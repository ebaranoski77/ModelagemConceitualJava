package com.elvisbaranoski.mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elvisbaranoski.mc.domain.Categoria;
import com.elvisbaranoski.mc.domain.Cidade;
import com.elvisbaranoski.mc.domain.Cliente;
import com.elvisbaranoski.mc.domain.Endereco;
import com.elvisbaranoski.mc.domain.Estado;
import com.elvisbaranoski.mc.domain.ItemPedido;
import com.elvisbaranoski.mc.domain.Pagamento;
import com.elvisbaranoski.mc.domain.PagamentoComBoleto;
import com.elvisbaranoski.mc.domain.PagamentoComCartao;
import com.elvisbaranoski.mc.domain.Pedido;
import com.elvisbaranoski.mc.domain.Produto;
import com.elvisbaranoski.mc.domain.enuns.EstadoPagamento;
import com.elvisbaranoski.mc.domain.enuns.TipoCliente;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;
import com.elvisbaranoski.mc.repositories.CidadeRepository;
import com.elvisbaranoski.mc.repositories.ClienteRepository;
import com.elvisbaranoski.mc.repositories.EnderecoRepository;
import com.elvisbaranoski.mc.repositories.EstadoRepository;
import com.elvisbaranoski.mc.repositories.ItemPedidoRepository;
import com.elvisbaranoski.mc.repositories.PagamentoRepository;
import com.elvisbaranoski.mc.repositories.PedidoRepository;
import com.elvisbaranoski.mc.repositories.ProdutoRepository;


@SpringBootApplication
public class CursoMc1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"INFORM??TICA");
		Categoria categoria2 = new Categoria(null,"ESCRIT??RIO");

		Produto produto1 = new Produto(null,"COMPUTADOR",2000.00);
		Produto produto2 = new Produto(null,"IMPRESSORA",1000.00);
		Produto produto3 = new Produto(null,"MOUSE",800.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));

		Estado estado1 = new Estado(null,"Minas Gerais");
		Estado estado2 = new Estado(null,"S??o Paulo");

		Cidade cidade1 = new Cidade(null,"Uberl??ndia",estado1);
		Cidade cidade2 = new Cidade(null,"S??o Paulo",estado2);
		Cidade cidade3 = new Cidade(null,"Campinas",estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));

		Cliente cliente1 = new Cliente(null,"Maria da Silva","maria@gmail.com","12345678900",TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("998184525","997845124"));
		Endereco endereco1 = new Endereco(null,"Rua Paraguai","07","casa","Santo Afonso","93425360",cliente1,cidade1);
		Endereco endereco2 = new Endereco(null,"Rua Uruguai","17","casa","Santo Afonso","93425368",cliente1,cidade2);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido pedido1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cliente1, endereco1);
		Pedido pedido2 = new Pedido(null,sdf.parse("10/10/2017 10:35"),cliente1, endereco2);

		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);

		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2,sdf.parse("20/10/2017 00:00"),null);
		pedido2.setPagamento(pagamento2);

		cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));

		ItemPedido itemPedido1 = new ItemPedido(pedido1,produto1,0.00,1,2000.00);
		ItemPedido itemPedido2 = new ItemPedido(pedido1,produto3,0.00,2,80.00);
		ItemPedido itemPedido3 = new ItemPedido(pedido2,produto2,100.00,1,800.00);

		pedido1.getItens().addAll(Arrays.asList(itemPedido1,itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));

		produto1.getItens().addAll(Arrays.asList(itemPedido1));
		produto2.getItens().addAll(Arrays.asList(itemPedido3));
		produto3.getItens().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll( Arrays.asList(itemPedido1,itemPedido2,itemPedido3));
		
	}


}
