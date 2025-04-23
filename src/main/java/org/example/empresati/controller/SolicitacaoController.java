package org.example.empresati.controller;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.empresati.dto.SolicitacaoEquipamentoDTO;
import org.example.empresati.dao.SolicitacaoEquipamentoDAO;

import java.time.LocalDate;

public class SolicitacaoController {
    @FXML private TextField tfNome;
    @FXML private DatePicker dpData;
    @FXML private TextField tfEquipamento;

    @FXML private TextField tfFilterNome;
    @FXML private TextField tfFilterEquipamento;

    @FXML private TableView<SolicitacaoEquipamentoDTO> tvSolicitacoes;
    @FXML private TableColumn<SolicitacaoEquipamentoDTO, Integer> colId;
    @FXML private TableColumn<SolicitacaoEquipamentoDTO, String>  colNome;
    @FXML private TableColumn<SolicitacaoEquipamentoDTO, String>  colEquip;
    @FXML private TableColumn<SolicitacaoEquipamentoDTO, LocalDate> colData;


    private final SolicitacaoEquipamentoDAO dao = new SolicitacaoEquipamentoDAO();
    private final ObservableList<SolicitacaoEquipamentoDTO> dados =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // liga as colunas aos campos do DTO
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nomeColaborador"));
        colEquip.setCellValueFactory(new PropertyValueFactory<>("equipamento"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));

        // carrega dados do banco
        dados.setAll(dao.listar());
        tvSolicitacoes.setItems(dados);

    }
    @FXML
    public void onSolicitar() {
        SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO();
        dto.setNomeColaborador(tfNome.getText());
        dto.setEquipamento(tfEquipamento.getText());
        dto.setDataSolicitacao(dpData.getValue());

        dao.inserir(dto);
        System.out.println("Solicitado com sucesso! /nID correspondente:" + dto.getId());
        dados.add(dto);
    }

}
