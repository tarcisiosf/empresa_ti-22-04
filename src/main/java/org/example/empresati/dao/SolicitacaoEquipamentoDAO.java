package org.example.empresati.dao;

import org.example.empresati.dto.SolicitacaoEquipamentoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoEquipamentoDAO {
    private final String URL = "jdbc:postgresql://localhost:5432/empresa_ti";
    private final String USER = "postgres";
    private final String PASS = "lamborguini129";

    public void inserir(SolicitacaoEquipamentoDTO dto) {
        String sql = "INSERT INTO solicitacoes (nome_colaborador, equipamento, data_solicitacao) VALUES (?,?,?)";
        try(Connection c = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, dto.getNomeColaborador());
            ps.setString(2, dto.getEquipamento());
            ps.setDate(3, Date.valueOf(dto.getDataSolicitacao()));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()) dto.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SolicitacaoEquipamentoDTO> listar() {
        List<SolicitacaoEquipamentoDTO> lista = new ArrayList<>();
        String sql = "SELECT id, nome_colaborador, equipamento, data_solicitacao FROM solicitacoes";
        try (Connection c = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SolicitacaoEquipamentoDTO dto = new SolicitacaoEquipamentoDTO();
                dto.setId(rs.getInt("id"));
                dto.setNomeColaborador(rs.getString("nome_colaborador"));
                dto.setEquipamento(rs.getString("equipamento"));
                dto.setDataSolicitacao(rs.getDate("data_solicitacao").toLocalDate());
                lista.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
