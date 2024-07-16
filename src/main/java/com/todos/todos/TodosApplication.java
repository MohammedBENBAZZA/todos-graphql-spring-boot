package com.todos.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@SpringBootApplication
public class TodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosApplication.class, args);
	}

	@Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> builder.type(TypeRuntimeWiring.newTypeWiring("Query")
            .dataFetcher("hello", env -> "Hello, world!"));
    }

}
