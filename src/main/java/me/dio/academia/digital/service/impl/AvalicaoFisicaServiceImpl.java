package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvalicaoFisicaServiceImpl implements IAvaliacaoFisicaService {
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).get());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        if (avaliacaoFisicaRepository.existsById(id)) return avaliacaoFisicaRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        if (avaliacaoFisicaRepository.existsById(id)){
            AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
            avaliacaoFisica.setPeso(formUpdate.getPeso());
            avaliacaoFisica.setAltura(formUpdate.getAltura());
            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        }else return null;
    }

    @Override
    public void delete(Long id) {
        if (avaliacaoFisicaRepository.existsById(id)) avaliacaoFisicaRepository.deleteById(id);
        else System.out.println("Id inválido");
    }
}
