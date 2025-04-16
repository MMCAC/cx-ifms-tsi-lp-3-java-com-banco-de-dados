/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lp3exconexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author renato
 */
public class FilmeDAO {
    private BD bd = null;
    private PreparedStatement ps = null;
    
    private boolean getConnection() {
        bd = new BD();
        return bd.getConnection();
    }
    
    public void consultar(String titulo) {
        if(getConnection()) {  // se conectou ao BD entra no if
            try {
                String sql = "select * from filmes where titulo = ?";
                ps = bd.connection.prepareStatement(sql);
                ps.setString(1, titulo);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    System.out.println("Id: " + rs.getString("codigo"));
                    System.out.println("Título: " + rs.getString("titulo"));
                    System.out.println("Gênero: " + rs.getString("genero"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema com o SQL: " 
                    + ex.toString());
            } finally {
                psClose();
                bd.close();
                System.out.println("Liberou os recursos");
            }            
        }
    }

    public Filme consultar(int id) {
        if(getConnection()) {  // se conectou ao BD entra no if
            try {
                String sql = "select * from filmes where codigo = ?";
                ps = bd.connection.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Filme filme = rs != null ? new Filme() : null;
                while(rs.next()) {
                    filme.setCodigo(Integer.parseInt(rs.getString("codigo")));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setGenero(rs.getString("genero"));
                    filme.setProdutora(rs.getString("produtora"));
                    filme.setDataCompra(rs.getString("datacompra"));
                }
                return filme;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema com o SQL: " 
                    + ex.toString());
                return null;
            } finally {
                psClose();
                bd.close();
            }            
        }
        return null;
    }
    
    public void inserir(Filme filme) {
        if(getConnection()) {  // se conectou ao BD entra no if
            try {
                String sql = "insert into filmes(titulo, genero, produtora, datacompra) " +
                             "values(? ,? ,? ,?)";
                ps = bd.connection.prepareStatement(sql);
                ps.setString(1, filme.getTitulo());
                ps.setString(2, filme.getGenero());
                ps.setString(3, filme.getProdutora());
                ps.setString(4, filme.getDataCompra());
                if(ps.executeUpdate() == 1)
                    System.out.println("Inserido com sucesso.");
                else
                    System.out.println("Falha ao inserir registro.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema com o SQL: " 
                    + ex.toString());
            } finally {
                psClose();
                bd.close();
                System.out.println("Liberou os recursos");
            }            
        }
    }
    public void remover(Filme filme) {
        if(consultar(filme.getCodigo()) != null)
            remover(filme.getCodigo());
    }
    
    public void remover(int id) {
        if(getConnection()) {  // se conectou ao BD entra no if
            try {
                String sql = "delete from filmes where codigo = ?";
                ps = bd.connection.prepareStatement(sql);
                ps.setInt(1, id);
                if(ps.executeUpdate() == 1)
                    JOptionPane.showMessageDialog(null, "Removido com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Falha na Remoção.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema com o SQL: " 
                    + ex.toString());
            } finally {
                psClose();
                bd.close();
                System.out.println("Liberou os recursos");
            }            
        }
    }
    
    public void atualizar(Filme filme) {
        if(getConnection()) {  // se conectou ao BD entra no if
            try {
                String sql = "update filmes set titulo = ?, genero = ?, produtora = ? "
                        + "where codigo = ?";
                ps = bd.connection.prepareStatement(sql);
                ps.setString(1, filme.getTitulo());
                ps.setString(2, filme.getGenero());
                ps.setString(3, filme.getProdutora());
                ps.setInt(4, filme.getCodigo());
                if(ps.executeUpdate() == 1)
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Falha na Atualização.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema com o SQL: " 
                    + ex.toString());
            } finally {
                psClose();
                bd.close();
                System.out.println("Liberou os recursos");
            }            
        }
    }
    
    private void psClose() {
        try {
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar PreparadeStatement " + ex.toString());
        }
    }
}
