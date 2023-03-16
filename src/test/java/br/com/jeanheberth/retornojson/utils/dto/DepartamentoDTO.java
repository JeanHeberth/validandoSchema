package br.com.jeanheberth.retornojson.utils.dto;

import lombok.*;

public class DepartamentoDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public class DepartamentoResponseDto {

        private Long id;
        private String nome;
        private Long numero;
    }
}
