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
public class Barco {
    private short idBarco;
    private String nomeBarco;
    private String corBarco;
    
    public Barco() {
    
    }
    
    public Barco(short idBarco, String nomeBarco, String corBarco) {
        this.idBarco = idBarco;
        this.nomeBarco = nomeBarco;
        this.corBarco = corBarco;
    }

    public int getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(short idBarco) {
        this.idBarco = idBarco;
    }

    public String getNomeBarco() {
        return nomeBarco;
    }

    public void setNomeBarco(String nomeBarco) {
        this.nomeBarco = nomeBarco;
    }

    public String getCorBarco() {
        return corBarco;
    }

    public void setCorBarco(String corBarco) {
        this.corBarco = corBarco;
    }

    @Override
    public String toString() {
        return "Barco{" + "idBarco=" + idBarco + ", nomeBarco=" + nomeBarco + ", corBarco=" + corBarco + '}';
    }
    
}
