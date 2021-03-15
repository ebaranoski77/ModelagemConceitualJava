package com.elvisbaranoski.mc;

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
import com.elvisbaranoski.mc.domain.Produto;
import com.elvisbaranoski.mc.domain.enuns.TipoCliente;
import com.elvisbaranoski.mc.repositories.CategoriaRepository;
import com.elvisbaranoski.mc.repositories.CidadeRepository;
import com.elvisbaranoski.mc.repositories.ClienteRepository;
import com.elvisbaranoski.mc.repositories.EnderecoRepository;
import com.elvisbaranoski.mc.repositories.EstadoRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"INFORMÁTICA");
		Categoria categoria2 = new Categoria(null,"ESCRITÓRIO");
		
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
		Estado estado2 = new Estado(null,"São Paulo");
		
		Cidade cidade1 = new Cidade(null,"Uberlândia",estado1);
		Cidade cidade2 = new Cidade(null,"São Paulo",estado2);
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
	}

}
