package com.mourao.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mourao.curso.entities.Categoria;
import com.mourao.curso.entities.ItensPedido;
import com.mourao.curso.entities.Pagamento;
import com.mourao.curso.entities.Pedido;
import com.mourao.curso.entities.Produto;
import com.mourao.curso.entities.Usuario;
import com.mourao.curso.entities.enums.PedidoStatus;
import com.mourao.curso.repositories.CategoriaRepository;
import com.mourao.curso.repositories.ItensPedidoRepository;
import com.mourao.curso.repositories.PedidoRepository;
import com.mourao.curso.repositories.ProdutoRepository;
import com.mourao.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido p1 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.PAGO, u1);

		Categoria c1 = new Categoria(null, "Eletrônicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computador");

		Produto pt1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pt2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pt3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pt4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pt5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		userRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(pt1, pt2, pt3, pt4, pt5));

		pt1.getCategorias().add(c2);
		pt2.getCategorias().add(c1);
		pt2.getCategorias().add(c3);
		pt3.getCategorias().add(c3);
		pt4.getCategorias().add(c3);
		pt5.getCategorias().add(c2);

		produtoRepository.saveAll(Arrays.asList(pt1, pt2, pt3, pt4, pt5));

		ItensPedido ip1 = new ItensPedido(p1, pt1, 2, pt1.getPreco());
		ItensPedido ip2 = new ItensPedido(p1, pt3, 1, pt3.getPreco());
		ItensPedido ip3 = new ItensPedido(p2, pt3, 2, pt3.getPreco());
		ItensPedido ip4 = new ItensPedido(p3, pt5, 2, pt5.getPreco());

		itensPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		Pagamento pg1 = new Pagamento(null, Instant.parse("2020-06-08T21:53:07Z"), p3);
		p3.setPagamento(pg1);
		
		pedidoRepository.save(p3);
	}
}
