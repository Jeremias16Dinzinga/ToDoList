package com.sweet_company.ToDoList;

import com.sweet_company.ToDoList.entity.ToDoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	@ExtendWith(MockitoExtension.class)
	void testToDoCreateSuccess() {
		var toDo = new ToDoEntity("Aula1","Terei aula de Inglês",false,1);

		webTestClient.
				post().uri("/toDo")
				.bodyValue(toDo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(toDo.getName())
				.jsonPath("$[0].description").isEqualTo(toDo.getDescription())
				.jsonPath("$[0].done").isEqualTo(toDo.isDone())
				.jsonPath("$[0].priority").isEqualTo(toDo.getPriority());
	}


	@Test
	@ExtendWith(MockitoExtension.class)
	void testToDoCreateFailed(){

		webTestClient.
				post().uri("/toDo")
				.bodyValue(
						new ToDoEntity("","",false,1))
				.exchange()
				.expectStatus().isBadRequest();

	}

	@Test
	@ExtendWith(MockitoExtension.class)
	void testToDoUpdateSuccess(){
		webTestClient
				.put().uri("/toDo")
				.bodyValue(
						new ToDoEntity(1,"tarefa2","Boa tarefa para semana",false,2)
				)
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	@ExtendWith(MockitoExtension.class)
	void testToDoUpdateFailed(){
		webTestClient
				.put().uri("/toDo")
				.bodyValue(
						new ToDoEntity(1,"","",false,2)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
