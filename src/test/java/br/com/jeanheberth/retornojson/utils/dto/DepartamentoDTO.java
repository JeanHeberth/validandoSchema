package br.com.jeanheberth.retornojson.utils.dto;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode
public class DepartamentoDTO {
    private Long id;
    private String nome;
    private Long numero;



}
