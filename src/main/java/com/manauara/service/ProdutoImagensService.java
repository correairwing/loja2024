package com.manauara.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manauara.entity.Produto;
import com.manauara.entity.ProdutoImagens;
import com.manauara.repository.ProdutoImagensRepository;
import com.manauara.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {


    @Autowired
    private ProdutoImagensRepository repository;

    @Autowired
    private ProdutoRepository prodRepository;

    public List<ProdutoImagens> buscarTodos() {
        return repository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto prod = prodRepository.findById(idProduto).get();
        ProdutoImagens newObj = new ProdutoImagens();

        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(prod.getId()) + file.getOriginalFilename();
                Path path = Paths
                .get("/home/correairwing/Documents/api-files/" + nomeImagem); 
                Files.write(path, bytes);
                newObj.setNome(nomeImagem);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        newObj.setProduto(prod);
        newObj.setDataCriacao(new Date());
        newObj = repository.saveAndFlush(newObj);
        return newObj;
    }

    public ProdutoImagens alterar(ProdutoImagens obj) {
        obj.setDataAtualizacao(new Date());
        ProdutoImagens newObj = repository.saveAndFlush(obj);
        return newObj;
    }

    public void excluir(Long id) {
        ProdutoImagens obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
