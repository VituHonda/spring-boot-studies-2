package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dto.CategoriaDTO;
import br.com.fiap.produtomvc.dto.DepartamentoDTO;
import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.models.Departamento;
import br.com.fiap.produtomvc.repository.DepartamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    @Transactional(readOnly = true)
    public List<DepartamentoDTO> findAll() {
        List<Departamento> list = repository.findAll();
        return list.stream().map(DepartamentoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public DepartamentoDTO insert(DepartamentoDTO dto) {
        Departamento entity = new Departamento();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartamentoDTO(entity);
    }

    @Transactional(readOnly = true)
    public DepartamentoDTO findById(Long id) {

        Departamento departamento = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return new DepartamentoDTO(departamento);
    }

    @Transactional
    public DepartamentoDTO update(Long id, DepartamentoDTO dto) {

        try {
            Departamento entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new DepartamentoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }

    private void copyDtoToEntity(DepartamentoDTO dto, Departamento entity) {
        entity.setNome(dto.getNome());
    }

}
