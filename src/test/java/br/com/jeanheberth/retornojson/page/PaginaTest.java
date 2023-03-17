package br.com.jeanheberth.retornojson.page;

import br.com.jeanheberth.retornojson.constantes.Constantes;
import br.com.jeanheberth.retornojson.utils.base.BaseTeste;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;

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

}
