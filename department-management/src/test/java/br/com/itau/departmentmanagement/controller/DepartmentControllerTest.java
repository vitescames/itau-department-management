package br.com.itau.departmentmanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.departmentmanagement.controller.dto.BoardDto;
import br.com.itau.departmentmanagement.controller.dto.DepartmentDto;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class DepartmentControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveDepartmentTest() throws Exception{
    	
    	DepartmentDto departmentDto = new DepartmentDto();
    	departmentDto.setId(5);
    	departmentDto.setBoardDto(new BoardDto(1, "teste"));
    	departmentDto.setCity("Cidade teste");
    	departmentDto.setLocation("Local teste");
    	departmentDto.setName("Teste name");
    	departmentDto.setState("Estado teste");
    	
    	mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/departments")
    			.contentType("application/json")
    			.content(objectMapper.writeValueAsString(departmentDto)))
    			.andExpect(MockMvcResultMatchers.status().isCreated());
    	
    }
    
    @Test
	public void getDepartmentsTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/departments")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("content")));
	}
    
    @Test
	public void deleteDepartmentTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/departments/1")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(containsString("successfully")));
	}

}
