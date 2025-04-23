package org.example.empresati.dto;

import java.time.LocalDate;

public class SolicitacaoEquipamentoDTO {
    private int id;
    private String nomeColaborador;
    private String equipamento;
    private LocalDate dataSolicitacao;

    public SolicitacaoEquipamentoDTO() {}

    public SolicitacaoEquipamentoDTO(int id, String nomeColaborador, String equipamento) {
        this.id = id;
        this.nomeColaborador = nomeColaborador;
        this.equipamento = equipamento;
        this.dataSolicitacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeColaborador() {
        return nomeColaborador;
    }
    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }
    public String getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }
    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
