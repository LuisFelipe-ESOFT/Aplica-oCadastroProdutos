package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ProdutoModel;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.cadastraProd(produto);
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listaProd();
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoModel produto) {
        return produtoService.atualizaProd(id, produto);
    }
    @DeleteMapping("/{id}")
    public void removeProd(@PathVariable Long id) {
        produtoService.deletaProd(id);
    }
}