/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Reserva;

/**
 *
 * @author User
 */
public class CReserva {
    ArrayList<Reserva> reservas = new ArrayList<>();
    short idMarinheiro;
    short idBarco;
    String dia;
    
    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }
    
    public void addReserva(Reserva r) {
        this.reservas.add(r);
    }
    
    public boolean removeReserva(Reserva r) {
        boolean rr = this.reservas.remove(r);
        return rr;
    }
    
    public void mokReservas() {
        Reserva r1 = new Reserva((short) 1, (short) 1, "01/01/2021");
        Reserva r2 = new Reserva((short) 1, (short) 2, "01/01/2021");
        Reserva r3 = new Reserva((short) 1, (short) 3, "04/02/2021");
        Reserva r4 = new Reserva((short) 1, (short) 4, "23/02/2021");
        Reserva r5 = new Reserva((short) 3, (short) 2, "24/03/2021");
        Reserva r6 = new Reserva((short) 3, (short) 3, "13/04/2021");
        Reserva r7 = new Reserva((short) 3, (short) 4, "15/05/2021");
        Reserva r8 = new Reserva((short) 6, (short) 1, "15/05/2021");
        Reserva r9 = new Reserva((short) 6, (short) 2, "21/06/2021");
        Reserva r10 = new Reserva((short) 8, (short) 3, "21/06/2021");
        Reserva r11 = new Reserva((short) 9, (short) 5, "22/06/2021");
        Reserva r12 = new Reserva((short) 8, (short) 6, "22/06/2021");
        
        this.addReserva(r1);
        this.addReserva(r2);
        this.addReserva(r3);
        this.addReserva(r4);
        this.addReserva(r5);
        this.addReserva(r6);
        this.addReserva(r7);
        this.addReserva(r8);
        this.addReserva(r9);
        this.addReserva(r10);
        this.addReserva(r11);
        this.addReserva(r12);
    }
    
    public Reserva selecionarReserva(String dia, short idBarco, short idMarinheiro) {
        Reserva r = null;
        for (Reserva listReservas: reservas) {
            if (listReservas.getIdMarinheiro() == idMarinheiro && listReservas.getIdBarco() == idBarco && listReservas.getDia().equals(dia)) {
                r = listReservas;
                break;
            }
        }
        return r;
    }
    
    public boolean verReserva(String dia, short idBarco) {
        boolean verificaReserva = false;
        for (Reserva listReservas: reservas) {
            if (listReservas.getDia().equals(dia) && listReservas.getIdBarco() == idBarco) {
                verificaReserva = true;
                break;
            }
        }
        return verificaReserva;
    }
    
    public boolean pesquisarReservasMarinheiro(short idMarinheiro) {
        
        return true;
    }
    
}
