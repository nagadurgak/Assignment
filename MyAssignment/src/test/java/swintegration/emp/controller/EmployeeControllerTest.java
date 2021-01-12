package swintegration.emp.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.HttpStatus;

import com.jayway.restassured.response.Response;

import swintegration.emp.model.Employee;

@TestMethodOrder(OrderAnnotation.class)
public class EmployeeControllerTest extends TestBase {
	static Integer id = null;
	
	@Test
	@Order(1)
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setAirstName("First1");
		employee.setLastName("Last1");
		employee.setEmail("fl1@gmail.com");
		employee.setPhone("1111111111");

		Response response = given()
		.contentType("application/json")
		.body(employee)
		.when().post("/employee").then()
		.statusCode(HttpStatus.OK.value())
		.extract().response();
		id = response.path("id");
	}
	
	@Test
	@Order(2)
	public void findById() {
		given()
		.contentType("application/json")
		.pathParam("id", id)
		.when().get("/employee/{id}").then()
		.body("email",equalTo("fl1@gmail.com"))
		.statusCode(HttpStatus.OK.value());

	}
	
	
	@Test
	@Order(3)
	public void updateEmployee() {
		Employee employee = new Employee();
		employee.setAirstName("UpdatedFirst1");
		employee.setLastName("UpdatedLast1");
		employee.setEmail("updatedfl1@gmail.com");
		employee.setPhone("1111111111");

		given()
		.contentType("application/json")
		.pathParam("id", id)
		.body(employee)
		.when().put("/employee/{id}").then()
		.body("id",equalTo(id))
		.statusCode(HttpStatus.OK.value());
	}
	
	
	@Test
	@Order(4)
	public void findAll() {
		given().when().get("/employee").then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	@Order(5)
	public void deleteEmployee()
	{
		given()
		.contentType("application/json")
		.pathParam("id", id)
		.when().delete("/employee/{id}").then()
		.statusCode(HttpStatus.NO_CONTENT.value());
	}

}
