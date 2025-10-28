package com.example.condominio.condomino;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondomino condomino){
        return "Cadastro efetuado com sucesso";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizarCondomino(@PathVariable String id,
            @Valid @RequestBody ContratoEntradaCadastroCondomino condomino) {
        return "Cadastro atualizado com efetuado com sucesso";
    }

    @GetMapping("/buscarPorCpf")
    @ResponseStatus(HttpStatus.OK)
    public String buscarCondominoPorCpf(@RequestParam("cpf") String cpf){
        return "Lista de condominio por Cpf";
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String buscarTodosCondominos() {
        return "Lista de todos os condominos";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletarCondomino(@PathVariable String id) {
        return "Condomino deletado com sucesso!";
    }
}
