package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvalicaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvalicaoFisicaServiceImpl service;
    @PostMapping
    public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form){
        return service.create(form);
    }
    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public AvaliacaoFisica get(@Valid @PathVariable("id") Long id){ return service.get(id);}
    @PutMapping("/{id}")
    public AvaliacaoFisica update(@Valid @PathVariable("id") Long id, @RequestBody AvaliacaoFisicaUpdateForm updateForm){
        return service.update(id,updateForm);
    }
    @DeleteMapping("/{id}")
    public void delete (@Valid @PathVariable("id") Long id) {service.delete(id);}
}
