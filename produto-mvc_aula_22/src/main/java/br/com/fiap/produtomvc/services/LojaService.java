package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.dto.LojaDTO;
import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.repository.LojaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Transactional(readOnly = true)
    public List<LojaDTO> findAll(){
        List<Loja> list = repository.findAll();
        return list.stream().map(LojaDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public LojaDTO insert(LojaDTO dto) {

        Loja entity = new Loja();
        copyToDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new LojaDTO(entity);

    }

    private void copyToDtoToEntity(LojaDTO dto, Loja entity) {
        entity.setNome(dto.getNome());
    }

    @Transactional(readOnly = true)
    public LojaDTO findById(Long id){
        Loja entity = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return new LojaDTO(entity);
    }

    @Transactional
    public LojaDTO update(Long id, LojaDTO dto){
        try{
            Loja entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity = repository.save(entity);
            return new LojaDTO(entity);
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

}
