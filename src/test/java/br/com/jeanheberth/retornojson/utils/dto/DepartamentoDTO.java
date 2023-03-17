package br.com.jeanheberth.retornojson.utils.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class DepartamentoDTO {


    @Data
    @EqualsAndHashCode
    public class DepartamentoResponseDto {

        private Long id;
        private String nome;
        private Long numero;
    }
}
