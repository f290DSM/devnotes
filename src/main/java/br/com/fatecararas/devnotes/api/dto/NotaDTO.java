package br.com.fatecararas.devnotes.api.dto;

import br.com.fatecararas.devnotes.model.entities.Categoria;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class NotaDTO {
    private Integer id;
    @NotEmpty(message = "Conteúdo é obrigatório.")
    @Length(max = 500, message = "Tamanho máximo é 500 caracteres")
    private String conteudo;
    private Categoria categoria;
}
