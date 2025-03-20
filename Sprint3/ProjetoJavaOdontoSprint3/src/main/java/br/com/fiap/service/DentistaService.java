package br.com.fiap.service;

import br.com.fiap.beans.Dentista;
import br.com.fiap.repository.DentistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service
@Service
@Transactional
public class DentistaService {
    @Autowired
    private DentistaRepository repository;

    @Autowired
    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    public Dentista salvarDentista(Dentista dentista) {
        return repository.save(dentista);
    }

    public void inserirDentista(Dentista dentista) {
        repository.inserirDentista(
                dentista.getIdDentista(),
                dentista.getNome(),
                dentista.getEspecialidade(),
                dentista.getCro(),
                dentista.getTaxaSinistros(),
                dentista.getIdEndereco()
        );
    }
}