package com.mourao.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mourao.curso.entities.Categoria;
import com.mourao.curso.entities.Pedido;
import com.mourao.curso.entities.Produto;
import com.mourao.curso.entities.User;
import com.mourao.curso.entities.enums.PedidoStatus;
import com.mourao.curso.repositories.CategoriaRepository;
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

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2020-06-08T19:53:07Z"), PedidoStatus.PAGO, u1);
		
		Categoria c1 = new Categoria(null, "Alimentos");
		Categoria c2 = new Categoria(null, "Brinquedos");
		Categoria c3 = new Categoria(null, "Eletrônicos");
		
		//Produto pt1 = new Produto(null, "Feijão", "feijão verde da roça", 4.5, null);
		Produto pt1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pt2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pt3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pt4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pt5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(pt1, pt2, pt3, pt4, pt5));
		
	}
}
