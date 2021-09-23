/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Marinheiro;

/**
 *
 * @author User
 */
public class CMarinheiro {
    ArrayList<Marinheiro> marinheiros = new ArrayList<>();
    short idMarinheiro = 1;
    
    public ArrayList<Marinheiro> getMarinheiros() {
        return marinheiros;
    }
    
    public short addIdMarinheiro() {
        return this.idMarinheiro++;
    }
    
    public void addMarinheiro(Marinheiro m) {
        this.marinheiros.add(m);
    }
    
    public void removeMarinheiro(Marinheiro m) {
        this.marinheiros.remove(m);
    }
    
    public void mokMarinheiros() {
        Marinheiro m1 = new Marinheiro(this.addIdMarinheiro(), "Carlos", (short) 7, 45f);
        Marinheiro m2 = new Marinheiro(this.addIdMarinheiro(), "Pedro", (short) 1, 33f);
        Marinheiro m3 = new Marinheiro(this.addIdMarinheiro(), "Paulo", (short) 8, 55.5f);
        Marinheiro m4 = new Marinheiro(this.addIdMarinheiro(), "Sérgio", (short) 8, 25.5f);
        Marinheiro m5 = new Marinheiro(this.addIdMarinheiro(), "Saulo", (short) 10, 35f);
        Marinheiro m6 = new Marinheiro(this.addIdMarinheiro(), "Fabricio", (short) 7, 35f);
        Marinheiro m7 = new Marinheiro(this.addIdMarinheiro(), "Felipe", (short) 10, 16f);
        Marinheiro m8 = new Marinheiro(this.addIdMarinheiro(), "Fabricio", (short) 9, 35f);
        Marinheiro m9 = new Marinheiro(this.addIdMarinheiro(), "Bruno", (short) 3, 25.5f);
        Marinheiro m10 = new Marinheiro(this.addIdMarinheiro(), "Daniel", (short) 3, 63.5f);
        
        this.addMarinheiro(m1);
        this.addMarinheiro(m2);
        this.addMarinheiro(m3);
        this.addMarinheiro(m4);
        this.addMarinheiro(m5);
        this.addMarinheiro(m6);
        this.addMarinheiro(m7);
        this.addMarinheiro(m8);
        this.addMarinheiro(m9);
        this.addMarinheiro(m10);
    }
    
    public boolean verId(short id) {
        boolean verId = false;
        for (Marinheiro listMarinheiro: marinheiros) { 
            if (listMarinheiro.getIdMarinheiro() == id) {
                verId = true;
                break;
            }
        }
        return verId;
    }
    
    public Marinheiro selecionaMarinheiro(short id) {
        Marinheiro m = new Marinheiro();
        for(Marinheiro listMarinheiros: marinheiros) {
            if (listMarinheiros.getIdMarinheiro() == id) {
                m = listMarinheiros;
                break;
            }
        }
        return m;
    }
    
    public String getNomeMarinheiro(short id) {
        String nome = null;
        for(Marinheiro listMarinheiros: marinheiros) {
            if (listMarinheiros.getIdMarinheiro() == id) {
                nome = listMarinheiros.getNomeMarinheiro();
                break;
            }
        }
        return nome;
    }
    
    public String getDadosMarinheiro(short id) {
        String dados = null;
        for(Marinheiro listMarinheiros: marinheiros) {
            if (listMarinheiros.getIdMarinheiro() == id) {
                dados = "Nome: " + listMarinheiros.getNomeMarinheiro() +
                        "\nStatus: " + listMarinheiros.isStatus() +
                        "\nIdade: " + listMarinheiros.getIdade();
                break;
            }
        }
        return dados;
    }
    
}
