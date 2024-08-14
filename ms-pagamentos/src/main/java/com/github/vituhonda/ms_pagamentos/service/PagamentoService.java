package com.github.vituhonda.ms_pagamentos.service;

import com.github.vituhonda.ms_pagamentos.dto.PagamentoDTO;
import com.github.vituhonda.ms_pagamentos.model.Pagamento;
import com.github.vituhonda.ms_pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional(readOnly = true)
    public List<PagamentoDTO> findAll() {
        List<Pagamento> list = repository.findAll();
        return list.stream().map(PagamentoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PagamentoDTO findById(Long id) {
        Pagamento entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado")
        );
        return new PagamentoDTO(entity);
    }

    @Transactional
    public PagamentoDTO insert(PagamentoDTO dto) {
        Pagamento entity = new Pagamento();
        CopyDtoToEntity(dto, entity);
        repository.save(entity);
        return new PagamentoDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
       if(!repository.existsById(id)) {
           throw new EntityNotFoundException("Recurso não encontrado");
       }
       try {
           repository.deleteById(id);
       } catch(EntityNotFoundException e) {
           throw new EntityNotFoundException("Recurso não encontrado");
        }
    }

    private void CopyDtoToEntity(PagamentoDTO dto, Pagamento entity) {
        entity.setValor(dto.getValor());
        entity.setNome(dto.getNome());
        entity.setNumeroDoCartao(dto.getNumeroDoCartao());
        entity.setValidade(dto.getValidade());
        entity.setCodigoDeSeguranca(dto.getCodigoDeSeguranca());
        entity.setStatus(dto.getStatus());
        entity.setPedidoId(dto.getPedidoId());
        entity.setFormaDePagamentoId(dto.getFormaDePagamentoId());
    }

}