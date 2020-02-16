package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;

/*
 * 
 * Classe que irá receber as requisições HTTP
 * 
 */

@RestController
@RequestMapping(value = "/api/")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retona uma lista de Produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retona um Produto atraves do ID")
	public Produto listaProduto(@PathVariable(value = "id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva um novo Produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um novo Produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
				
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um novo Produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

}


/*

GetMapping
http://localhost:8080/api/produtos
http://localhost:8080/api/produto/30

PostMapping
http://localhost:8080/api/produto
Body JSON
{
    "nome": "Produto | Post",
    "quantidade": 1.00,
    "valor": 1.00,
    "id": 999
}

PutMapping
http://localhost:8080/api/produto
Body JSON
{
    "nome": "Produto | Put",
    "quantidade": 1.00,
    "valor": 1.00,
    "id": 999
}

DeleteMapping
http://localhost:8080/api/produto
{
    "nome": "Produto | Put",
    "quantidade": 1.00,
    "valor": 1.00,
    "id": 999
}

*/