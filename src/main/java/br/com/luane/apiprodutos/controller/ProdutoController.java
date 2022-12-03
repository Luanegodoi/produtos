package br.com.luane.apiprodutos.controller;

import br.com.luane.apiprodutos.entity.ProdutoEntity;
import br.com.luane.apiprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<ProdutoEntity>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());

    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<ProdutoEntity> findProductsById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoRepository.findById(id).get());

    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<ProdutoEntity> createProducts(@RequestBody ProdutoEntity produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoRepository.save(produto));


    }

    @PutMapping(value="/produtos")
    public ResponseEntity<ProdutoEntity> updateProduct(@RequestBody ProdutoEntity produto){
        produtoRepository.saveAndFlush(produto);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping (value = "/produtos/{id}")
    public ResponseEntity<Void> deleteProductsById(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
