package br.com.itau.departmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.itau.departmentmanagement.exceptions.DepartmentNotFoundException;

@SpringBootApplication
@Import(DepartmentNotFoundException.class)
public class DepartmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentManagementApplication.class, args);
	}

}
 