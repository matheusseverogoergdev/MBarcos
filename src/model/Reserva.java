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
public class Reserva {
    private short idMarinheiro;
    private short idBarco;
    private String dia;
    
    public Reserva() {
    
    }
    
    public Reserva(short idMarinheiro, short idBarco, String dia) {
        this.idMarinheiro = idMarinheiro;
        this.idBarco = idBarco;
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getIdMarinheiro() {
        return idMarinheiro;
    }

    public void setIdMarinheiro(short idMarinheiro) {
        this.idMarinheiro = idMarinheiro;
    }

    public int getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(short idBarco) {
        this.idBarco = idBarco;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idMarinheiro=" + idMarinheiro + ", idBarco=" + idBarco + ", dia=" + dia + '}';
    }
    
}
