package br.com.jeanheberth.retornojson.page;

import br.com.jeanheberth.retornojson.constantes.Constantes;
import br.com.jeanheberth.retornojson.utils.base.BaseTeste;
import br.com.jeanheberth.retornojson.utils.dto.DepartamentoDTO;
import com.jayway.jsonpath.internal.function.numeric.Sum;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.resolve;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

class PaginaTest extends BaseTeste {

    @Autowired
    MockRestServiceServer server;

    @Test
    void testeRetornarPagina() {
        given()
                .spec(urlBase)
                .log().all()
                .when()
                .get(Constantes.olaMundo)
                .then()
                .statusCode(200)
                .body(containsString("Ola Mundo!"));

    }

    @Test
    void consultarJsonComUmDado() {

        given()
                .spec(urlBase)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Constantes.ID_USERS + 1)
                .then()
                .statusCode(200)
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/testeComUmDado.json"));
        //  Assertions.assertEquals();
    }

    @Test
    void consultarJsonComVariosDados() {
        given()
                .spec(urlBase)
                .contentType(ContentType.JSON)
                .when()
                .get(Constantes.ALL_USERS)
                .andReturn()
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/testeComVariosDados.json"))
                .extract();

    }

    @Test
    void deveVerificarUsuario() {
        given()
                .spec(urlBase)
                .when()
                .get(Constantes.ID_USERS + 1)
                .then()
                .statusCode(200)
                .log().all()
                .body("id", is(1))
                .body("nome", containsString("Departamento Pessoal"))
                .body("numero", is(20));

    }

//    @Test
//    void deveVerficarUsuario1() {
//
//        List<DepartamentoDTO> dtoList = List.of(DepartamentoDTO.builder()
//                .id(1L)
//                .nome("Departamento pessoal")
//                .numero(10L)
//                .build());
//        when();
//
//        server.expect(requestTo("http://localhost:8088/departamentos/1"))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withSuccess(new ClassPathResource("schemas/testeComVariosDados.json"),
//                        MediaType.APPLICATION_JSON
//                ));
//
//
//    }

}



