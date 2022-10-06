/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

import java.util.Date;

/**
 *
 * @author Alexandre
 */
public class Evento {
    private String nome, imagemCartaz;
    private Date dataHoraInicio, dataHoraTermino; 
    private int numVagas, colunas, fileiras, IDEvento, qtdAssentos;
    private double valorIngresso;
    private boolean [][] listaAssentos;

    public Evento(String nome, String imagemCartaz, Date dataHoraInicio,
            Date dataHoraTermino, int numVagas, double valorIngresso,
            boolean[][] listaAssentos, int colunas, int fileiras) {
        this.nome = nome;
        this.imagemCartaz = imagemCartaz;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.numVagas = numVagas;
        this.valorIngresso = valorIngresso;
        this.colunas = colunas;
        this.fileiras = fileiras;
        this.qtdAssentos = colunas * fileiras;
        inicializarAssentos(colunas, fileiras);
    }
    
    public Evento(String nome, String imagemCartaz, Date dataHoraInicio,
            Date dataHoraTermino, int numVagas, double valorIngresso, int colunas, int fileiras) {
        this.nome = nome;
        this.imagemCartaz = imagemCartaz;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.numVagas = numVagas;
        this.valorIngresso = valorIngresso;
        this.qtdAssentos = colunas * fileiras;
        inicializarAssentos(colunas, fileiras);
    }

    private void inicializarAssentos(int colunas, int fileiras) {
        for(int i = 0; i < colunas; i++){
            for(int j = 0; j < fileiras; j++){
                this.listaAssentos[i][j] = false;
            }
        }
    }

    public int getQtdAssentos() {
        return qtdAssentos;
    }
    
    public int getIDEvento() {
        return IDEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemCartaz() {
        return imagemCartaz;
    }

    public void setImagemCartaz(String imagemCartaz) {
        this.imagemCartaz = imagemCartaz;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(Date dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int getFileiras() {
        return fileiras;
    }

    public void setFileiras(int fileiras) {
        this.fileiras = fileiras;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public boolean[][] getListaAssentos() {
        return listaAssentos;
    }

    public void setListaAssentos(boolean[][] listaAssentos) {
        this.listaAssentos = listaAssentos;
    }
}
