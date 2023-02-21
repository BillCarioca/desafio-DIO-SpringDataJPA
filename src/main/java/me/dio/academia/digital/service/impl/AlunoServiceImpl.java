package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.handler.BusinessException;
import me.dio.academia.digital.infra.util.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl  implements IAlunoService {
    @Autowired
    private AlunoRepository repository;
    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return repository.save(aluno);
    }
    @Override
    public Aluno get(Long id) {

        if (repository.existsById(id)) return repository.findById(id).get();
        else throw new BusinessException("Id inválido");
    }
    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento==null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findBydataDeNascimento(localDate);
        }
    }
    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        if (repository.existsById(id)){
            Aluno aluno = repository.findById(id).get();
            aluno.setNome(formUpdate.getNome());
            aluno.setBairro(formUpdate.getBairro());
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
            return repository.save(aluno);
        }else  throw new BusinessException("Id inválido");
    }
    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }else throw new BusinessException("Id inválido");
    }

    @Override
    public List<AvaliacaoFisica> getAllAvalicaoFisicaId(Long id) {
        return repository.findById(id).get().getAvaliacoes();
    }
}
