/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.lp3exconexao;

/**
 *
 * @author renato
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FilmeDAO fd = new FilmeDAO();
//        Filme filme = new Filme("X-Men", "Ação", "Marvel", null);
//        fd.inserir(filme);
          Filme filme = new Filme();
          filme = fd.consultar(7342);
          filme.setGenero("Scifi");
          fd.atualizar(filme);
        System.out.println(filme.getCodigo());
        System.out.println(filme.getTitulo());
        System.out.println(filme.getGenero());
        System.out.println(filme.getProdutora());
        System.out.println(filme.getDataCompra());
//        fd.inserir("Testando 123458910", "Drama", "Disney", null);
//        fd.consultar(7338);
//        fd.remover(7337);
//        fd.atualizar(7338, "O Todo Poderoso", "Comédia");
//        fd.consultar(7338);
        
    }
    
}
