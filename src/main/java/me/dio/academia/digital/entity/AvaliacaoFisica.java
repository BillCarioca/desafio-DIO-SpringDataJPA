package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

public class AvaliacaoFisica {

    private Long id;

    private Aluno aluno;


    private double peso;

    private double altura;

    private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
}
