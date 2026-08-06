package br.com.fiap.tranquiloexpress.service;

import br.com.fiap.tranquilo_express.model.Mercado;
import br.com.fiap.tranquilo_express.repository.MercadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoService {

    private final MercadoRepository repository;

    // dependência via construtor
    public MercadoService(MercadoRepository repository) {
        this.repository = repository;
    }

    public List<Mercado> listarTodos() {
        return repository.findAll();
    }

    public Optional<Mercado> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Mercado salvar(Mercado mercado) {
        return repository.save(mercado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}