package com.example.condominio.entrypoint;

import com.example.condominio.adapter.CondominoAdapterEntrypoint;
import com.example.condominio.adapter.CondominoAdapterEntrypointImpl;
import com.example.condominio.business.CondominoBusiness;
import com.example.condominio.domain.Condomino;
import com.example.condominio.entrypoint.dto.CondominoSaidaDTO;
import com.example.condominio.entrypoint.dto.ContratoEntradaAtualizacaoCondominoDTO;
import com.example.condominio.entrypoint.dto.ContratoEntradaCadastroCondominoDTO;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @Autowired
    private CondominoBusiness condominoBusiness;
    @Autowired
    private CondominoAdapterEntrypoint condominoAdapter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoSaidaDTO cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondominoDTO condomino) {
        Condomino condominoConvertido = condominoAdapter.toDomain(condomino);
        Condomino condominoSalvo = condominoBusiness.cadastrarCondomino(condominoConvertido);

        return condominoAdapter.toSaidaDTO(condominoSalvo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CondominoSaidaDTO atualizarCondomino(@Valid @RequestBody ContratoEntradaAtualizacaoCondominoDTO condomino,
                                                @PathVariable String id) {
        Condomino condominoConvertido = condominoAdapter.toDomain(condomino, id);
        Condomino condominoAtualizado = condominoBusiness.atualizarCondomino(condominoConvertido);
        return condominoAdapter.toSaidaDTO(condominoAtualizado);
    }

    @GetMapping("/filtros")
    @ResponseStatus(HttpStatus.OK)
    public List<CondominoSaidaDTO> consultarCondominoComFiltros(@Nullable @RequestParam("nome") String nome,
                                                                @Nullable @RequestParam("cpf") String cpf,
                                                                @Nullable @RequestParam("bloco") String bloco,
                                                                @Nullable @RequestParam("apartamento") String apartamento) {
        List<Condomino> condominos = condominoBusiness.consultarCondominoComFiltros(nome, cpf, bloco, apartamento);
        return condominos.stream().map(condominoAdapter::toSaidaDTO).toList();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CondominoSaidaDTO> consultarCondomino() {
        List<Condomino> condominos = condominoBusiness.consultarTodosCondominos();
        return condominos.stream().map(condominoAdapter::toSaidaDTO).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCondomino(@PathVariable String id) {
        condominoBusiness.deletarCondomino(id);
    }
}