package br.com.fiap.tranquilo_express.controller;

import br.com.fiap.tranquilo_express.model.Mercado;
import br.com.fiap.tranquiloexpress.service.MercadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService service;

    public MercadoController(MercadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mercado>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercado> buscarPorId(@PathVariable Long id) {
        Optional<Mercado> mercado = service.buscarPorId(id);
        return mercado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mercado> criar(@RequestBody Mercado mercado) {
        Mercado novoMercado = service.salvar(mercado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMercado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> atualizar(@PathVariable Long id, @RequestBody Mercado mercadoAtualizado) {
        return service.buscarPorId(id).map(mercado -> {
            mercado.setNome(mercadoAtualizado.getNome());
            mercado.setTipo(mercadoAtualizado.getTipo());
            mercado.setSetor(mercadoAtualizado.getSetor());
            mercado.setTamanho(mercadoAtualizado.getTamanho());
            mercado.setPreco(mercadoAtualizado.getPreco());
            return ResponseEntity.ok(service.salvar(mercado));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Mercado> atualizarParcial(@PathVariable Long id, @RequestBody Mercado mercadoAtualizado) {
        return service.buscarPorId(id).map(mercado -> {
            if (mercadoAtualizado.getNome() != null) mercado.setNome(mercadoAtualizado.getNome());
            if (mercadoAtualizado.getPreco() != null) mercado.setPreco(mercadoAtualizado.getPreco());
            return ResponseEntity.ok(service.salvar(mercado));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}