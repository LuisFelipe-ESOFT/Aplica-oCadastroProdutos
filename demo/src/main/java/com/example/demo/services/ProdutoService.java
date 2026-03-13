package com.example.demo.services;

import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ProdutoModel cadastraProd(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }
    @GetMapping
    public List<ProdutoModel> listaProd(){
        return produtoRepository.findAll();
    }
    @PutMapping("/{id}")
    public static ProdutoModel atualizaProd(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        return ProdutoService.atualizaProd(id, produto);
    }
    @DeleteMapping("/{id}")
    public static void deletaProd(@PathVariable Long id) {
        ProdutoService.deletaProd(id);
    }

}

