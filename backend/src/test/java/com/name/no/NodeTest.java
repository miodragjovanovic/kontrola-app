package com.name.no;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class NodeTest {
	
	@Test
    public void createNodeSuccess() {
        given().when().post("/api/createNode?name=CEO").then().statusCode(200);
    }
	
	@Test
    public void createNodeFailure() {
        given().when().post("/api/createNode").then().statusCode(400);
    }
	
	@Test
    public void getAllNodesSuccess() {
        given().when().get("/api/getAllNodes").then().statusCode(200);
    }
	
	@Test
    public void getNodeByParentIdSuccess() {
        given().when().get("/api/getByParent?parentId=a8d1c568-ed69-46a6-be41-5a7a9e873d9c").then().statusCode(200);
    }
	
	@Test
    public void getNodeByParentIdFailure() {
        given().when().get("/api/getByParent").then().statusCode(400);
    }
	

}
