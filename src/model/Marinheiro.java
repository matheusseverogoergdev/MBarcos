/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Marinheiro {
    private short idMarinheiro;
    private String nomeMarinheiro;
    private short status;
    private float idade;
    
    public Marinheiro() {
    
    }
    
    public Marinheiro(short idMarinheiro, String nomeMarinheiro, short status, float idade) {
        this.idMarinheiro = idMarinheiro;
        this.nomeMarinheiro = nomeMarinheiro;
        this.status = status;
        this.idade = idade;
    }

    public short getIdMarinheiro() {
        return idMarinheiro;
    }

    public void setIdMarinheiro(short idMarinheiro) {
        this.idMarinheiro = idMarinheiro;
    }

    public String getNomeMarinheiro() {
        return nomeMarinheiro;
    }

    public void setNomeMarinheiro(String nomeMarinheiro) {
        this.nomeMarinheiro = nomeMarinheiro;
    }

    public short isStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public float getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Marinheiro{" + "idMarinheiro=" + idMarinheiro + ", nomeMarinheiro=" + nomeMarinheiro + ", status=" + status + ", idade=" + idade + '}';
    }
}
