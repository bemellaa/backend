package com.example.crud;

import com.example.crud.controller.ProductController;
import com.example.crud.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private ProductController productController;

	@Autowired
	private UserController userController;

	// TEST 1: Verificar que el contexto de Spring arranca (Conexión a BD exitosa)
	@Test
	void contextLoads() {
		// Si este test pasa, significa que el Backend no explotó al iniciar.
	}

	// TEST 2: Verificar que el Controlador de Productos existe
	@Test
	void productControllerLoads() {
		assertThat(productController).isNotNull();
	}

	// TEST 3: Verificar que el Controlador de Usuarios existe
	@Test
	void userControllerLoads() {
		assertThat(userController).isNotNull();
	}
}