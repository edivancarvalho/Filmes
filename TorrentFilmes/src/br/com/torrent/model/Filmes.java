package br.com.torrent.model;

/**
 *
 * @author CCE
 */
public class Filmes {
    private int iden;
    private String sinopse;
    private String titulo;
    private int ano;

    public Filmes(int iden, String sinopse, String titulo, int ano) {
        this.iden = iden;
        this.sinopse = sinopse;
        this.titulo = titulo;
        this.ano = ano;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
    
}
