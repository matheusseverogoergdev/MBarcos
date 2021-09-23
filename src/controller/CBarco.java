/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Barco;

/**
 *
 * @author User
 */
public class CBarco {
    ArrayList<Barco> barcos = new ArrayList<>();
    short idBarco = 1;
    
    public short addIdBarco() {
        return this.idBarco++;
    }
    
    public ArrayList<Barco> getBarcos() {
        return this.barcos;
    }
    
    public void addBarco(Barco b) {
        this.barcos.add(b);
    }
    
    public boolean removeBarro(Barco b) {
        boolean rb = this.barcos.remove(b);
        return rb;
    }
    
    public void mokBarcos() {
        Barco b1 = new Barco(this.addIdBarco(), "Amazonas", "Azul");
        Barco b2 = new Barco(this.addIdBarco(), "Amazonas", "Vermelho");
        Barco b3 = new Barco(this.addIdBarco(), "Mississipi", "Verde");
        Barco b4 = new Barco(this.addIdBarco(), "Avalon", "Vermelho");
        Barco b5 = new Barco(this.addIdBarco(), "Paz", "Azul");
        Barco b6 = new Barco(this.addIdBarco(), "Paz", "Azul");
        
        this.addBarco(b1);
        this.addBarco(b2);
        this.addBarco(b3);
        this.addBarco(b4);
        this.addBarco(b5);
        this.addBarco(b6);
    }
    
    public boolean verId(short idBarco) {
        boolean verId = false;
        for (Barco listBarcos: barcos) {
            if (listBarcos.getIdBarco() == idBarco) {
                verId = true;
                break;
            }
        }
        return verId;
    }
    
    public Barco selecionaBarco(short idBarco) {
        Barco b = new Barco();
        for (Barco listBarcos: barcos) {
            if (listBarcos.getIdBarco() == idBarco) {
                b = listBarcos;
                break;
            }
        }
        return b;
    }
    
    public String getNomeBarco(short id) {
        String nome = null;
        for(Barco listMarinheiros: barcos) {
            if (listMarinheiros.getIdBarco() == id) {
                nome = listMarinheiros.getNomeBarco();
                break;
            }
        }
        return nome;
    }    
    
}
