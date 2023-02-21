package me.dio.academia.digital.controller;


import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;
    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){ return service.create(form); }
    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento",required = false)
                                  String dataDeNascimento){
       return service.getAll(dataDeNascimento);
    }
    @GetMapping("/{id}")
    public Aluno get(@Valid @PathVariable("id") Long id){
        return service.get(id);
    }
    @GetMapping("/{id}/avaliaçoes")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@Valid @PathVariable("id") Long id){
        return service.getAllAvalicaoFisicaId(id);
    }
    @PutMapping("/{id}")
    public Aluno update(@Valid @PathVariable("id") Long id,@RequestBody AlunoUpdateForm updateForm){
        return service.update(id,updateForm);
    }
    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable("id") Long id) {
        service.delete(id);
    }
}
