package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dto.LojaDTO;
import br.com.fiap.produtomvc.dto.ProdutoDTO;
import br.com.fiap.produtomvc.dto.ProjetoDTO;
import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.models.Projeto;
import br.com.fiap.produtomvc.repository.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Transactional(readOnly = true)
    public List<ProjetoDTO> findAll(){
        List<Projeto> list = repository.findAll();
        return list.stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ProjetoDTO insert(ProjetoDTO dto) {

        Projeto entity = new Projeto();
        copyToDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProjetoDTO(entity);
    }

    @Transactional(readOnly = true)
    public ProjetoDTO findById(Long id){
        Projeto entity = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return new ProjetoDTO(entity);
    }

    @Transactional
    public ProjetoDTO update(Long id, ProjetoDTO dto){
        try{
            Projeto entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = repository.save(entity);
            return new ProjetoDTO(entity);
        } catch (EntityNotFoundException e){
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }

        try{
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    private void copyToDtoToEntity(ProjetoDTO dto, Projeto entity) {
        entity.setNome(dto.getNome());
    }


}
