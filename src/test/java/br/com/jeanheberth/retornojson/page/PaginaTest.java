package br.com.jeanheberth.retornojson.page;

import br.com.jeanheberth.retornojson.constantes.Constantes;
import br.com.jeanheberth.retornojson.utils.base.BaseTeste;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class PaginaTest extends BaseTeste {

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
    void consultarUsuario() {
    String sV = given()
                .spec(urlBase)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Constantes.ALL_USERS)
                .then()
             .statusCode(200)
             .log().all()
             .body(JsonSchemaValidator
                     .matchesJsonSchemaInClasspath("schemas/teste.json")
                ).toString()
            ;
    }
}
