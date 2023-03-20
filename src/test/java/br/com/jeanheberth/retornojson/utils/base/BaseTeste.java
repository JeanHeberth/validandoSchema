package br.com.jeanheberth.retornojson.utils.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static br.com.jeanheberth.retornojson.constantes.Constantes.url;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTeste {

    protected static RequestSpecification urlBase = new RequestSpecBuilder()
            .setBaseUri(url)
            .build();

}
