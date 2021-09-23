/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import controller.CBarco;
import controller.CMarinheiro;
import controller.CReserva;
import java.time.*;
import model.Barco;
import model.Marinheiro;
import model.Reserva;

/**
 *
 * @author User
 */
public class main {

    public static Scanner ler = new Scanner(System.in);
    public static CBarco cadBarcos = new CBarco();
    public static CMarinheiro cadMarinheiros = new CMarinheiro();
    public static CReserva cadReservas = new CReserva();

    public static String leTexto() {
        Scanner leTexto = new Scanner(System.in);
        return leTexto.nextLine().trim().replaceAll("  +", " ");
    }

    public static String leNomeCompleto() {
        Scanner leNome = new Scanner(System.in);
        String nome;
        boolean condition;
        do {
            nome = leNome.nextLine().toUpperCase().trim().replaceAll("  +", " ");
            condition = nome.isBlank();
            if (condition) {
                System.out.println("Você não preencheu o nome completo, preencha corretamente.");
            } else {
                if (nome.length() > 1) {
                    String[] palavras = nome.split("\\s");
                    nome = "";
                    for (String p:palavras) {
                        String primeiraLetra = p.substring(0,1);
                        String letrasRestantes = p.substring(1).toLowerCase();
                        nome += primeiraLetra + letrasRestantes + " ";
                    }
                }
            }
        } while(condition);
        return nome.trim();
    }

    public static void menuPrincipal() {
        System.out.println("--- Menu Principal ---");
        System.out.println("1 - Listar Marinheiros");
        System.out.println("2 - Listar Barcos");
        System.out.println("3 - Listar Reservas");
        System.out.println("4 - Cadastrar Reserva");
        System.out.println("5 - Deletar Reserva");
        System.out.println("6 - Editar Reserva");
        System.out.println("7 - Incremente o status do marinheiro em 1");
        System.out.println("8 - Pesquisa reservas por marinheiro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarReservas() {
        boolean condicao;
        do {
            short idMarinheiro;
            short idBarco;
            String data = "";
            
            System.out.println("\n--- Cadastro de Reservas ---");
            boolean verificaId = false;
            do {
                System.out.print("Informe o id do marinheiro: ");
                // Peço o id do marinheiro
                idMarinheiro = ler.nextShort();
                // Verifico se existe
                verificaId = cadMarinheiros.verId(idMarinheiro);
                if (verificaId) {
                    Marinheiro dadosDoMarinheiro = cadMarinheiros.selecionaMarinheiro(idMarinheiro);
                    // Se existe, eu mostro quem foi encontrado e pergunto se realmente deseja inserir essa pessoa.
//                    System.out.println("Marinheiro encontrado"
//                            + "\nNome: " + dadosDoMarinheiro.getNomeMarinheiro()
//                            + "\nStatus: " + dadosDoMarinheiro.isStatus()
//                            + "\nIdade: " + dadosDoMarinheiro.getIdade());
                    System.out.println("Marinheiro encontrado"
                        + cadMarinheiros.getDadosMarinheiro(idMarinheiro));
                    System.out.print("É essa a pessoa que você deseja selecionar? 1- Sim | 0 - Não: ");
                    verificaId = ler.nextShort() == 1;
                    System.out.println("");
                } else {
                    // Se não existir, eu mostro uma mensagem de erro e peço para o usuário digitar novamente.
                    System.out.println("Marinheiro não encontrado, por favor digite um novo Id.");
                }
            } while(!verificaId);
            
            boolean verificaIdBarco = false;
            do {
                System.out.print("Informe o id do barco: ");
                // Peço o id do barco
                idBarco = ler.nextShort();
                // Verifico se o barco existe
                verificaIdBarco = cadBarcos.verId(idBarco);
                if (verificaIdBarco) {
                    Barco dadosDoBarco = cadBarcos.selecionaBarco(idBarco);
                    // Se existe, eu vou mostrar qual barco foi encontrado e perguntar se deseja realmente alterar este barco
                    System.out.println("Barco encontrado"
                            + "\nNome: " + dadosDoBarco.getNomeBarco()
                            + "\nCor: " + dadosDoBarco.getCorBarco());
                    System.out.print("É esse o barco que você deseja selecionar? 1- Sim | 0 - Não: ");
                    verificaIdBarco = ler.nextShort() == 1;
                    System.out.println("");
                } else {
                    // Se não existir, eu mostro uma mensagem de erro e peço para o usuário digitar novamente
                    System.out.println("Barco não encontrado, por favor digite um novo Id.");
                }
            } while(!verificaIdBarco);
                
            LocalDate dataAtual = LocalDate.now();
            boolean verificaData = false;
            do {
                short anoAtual = (short) dataAtual.getYear();
                System.out.print("Digite o ano da reserva: ");
                short ano = ler.nextShort();
                if (ano < anoAtual) {
                    System.out.println("Ano inválido, digite um ano maior ou igual ao ano atual (" + anoAtual + ").");
                } else {
                    if ((ano - anoAtual) > 10) {
                        System.out.println("A reserva não pode ser 10 anos acima do ano atual (" + anoAtual + ").");
                    } else {
                        byte mesAtual = (byte) dataAtual.getMonthValue();
                        System.out.print("Digite o mês da reserva: ");
                        byte mes = ler.nextByte();
                        if (mes < 1 || mes > 12) {
                            System.out.println("Não existe mês de número: " + mes + ", digite um número de 1 até 12!");
                        } else {
                            if (ano == anoAtual && mes < mesAtual) {
                                System.out.println("Mês inválido!"
                                        + "\nVocê digitou: " + mes
                                        + ", digite um mês maior ou igual ao mês atual (" + mesAtual + ").");
                            } else {
                                byte diaAtual = (byte) dataAtual.getDayOfMonth();
                                byte limiteDeDias;
                                System.out.print("Digite o dia do mês da reserva: ");
                                byte dia = ler.nextByte();
                                switch (mes) {
                                    case 1:
                                    case 3:
                                    case 5:
                                    case 7:
                                    case 8:
                                    case 10:
                                    case 12:
                                        limiteDeDias = 31;
                                        break;
                                    case 2:
                                        if (ano % 4 == 0  && ano % 100 != 0) {
                                            limiteDeDias = 29;
                                            System.out.println("É um ano bissexto.");
                                        } else if (ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0) {
                                            limiteDeDias = 29;
                                            System.out.println("É um ano bissexto.");
                                        } else {
                                            limiteDeDias = 28;
                                            System.out.println("Não é um ano bissexto.");
                                        }
                                        break;
                                    default:
                                        limiteDeDias = 30;
                                        break;
                                }
                                if (dia < 1 || dia > limiteDeDias) {
                                    System.out.println("Dia do mês inválido!"
                                            + "\nDigite um número entre 1 e " + limiteDeDias
                                            + ", pois o mês é: " + mes + ".");
                                } else {
                                    if (ano == anoAtual && mes == mesAtual && dia < diaAtual) {
                                        System.out.println("Dia do mês inválido!"
                                        + "\nVocê digitou: " + dia
                                        + ", digite um dia maior ou igual ao dia atual (" + diaAtual + ").");
                                    } else {
                                        data = String.format("%02d", dia) + "/"
                                            + String.format("%02d", mes) + "/"
                                            + String.format("%04d", ano);
                                        verificaData = true;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("");
            } while(!verificaData);
            
            if (!cadReservas.verReserva(data, idBarco)) {
                Reserva r = new Reserva(idMarinheiro, idBarco, data);
                cadReservas.addReserva(r);
                System.out.println("Reserva concluída com sucesso para a data: " + data
                    + "\nMarinheiro: " + cadMarinheiros.getNomeMarinheiro((short) r.getIdMarinheiro())
                    + "\nBarco: " + cadBarcos.getNomeBarco((short) r.getIdBarco()));
                System.out.print("Deseja continuar cadastrando reservas? 1 - Sim / 0 - Não: ");
                condicao = (ler.nextInt() == 1);
                System.out.println("");
            } else {
                System.out.println("Reserva já cadastrada, cadastre novamente.");
                break;
            }
        } while(condicao == true);
    }
    
    public static void visualizarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva listReservas: cadReservas.getReservas()) {
            System.out.println("Data: " + listReservas.getDia()
                            + "\nId do barco: " + listReservas.getIdBarco()
                            + "\nId do marinheiro: " + listReservas.getIdMarinheiro()
                            + "\nNome do barco: " + cadBarcos.getNomeBarco((short) listReservas.getIdBarco())
                            + "\nNome do marinheiro: " + cadMarinheiros.getNomeMarinheiro((short) listReservas.getIdMarinheiro())
                            + "\n");
        }
    }
    
    public static void visualizarMarinheiros() {
        System.out.println("\n--- Lista de Marinheiros ---");
        for (Marinheiro listMarinheiros: cadMarinheiros.getMarinheiros()) {
            System.out.println("Id do marinheiro: " + listMarinheiros.getIdMarinheiro()
                            + "\nNome do marinheiro: " + listMarinheiros.getNomeMarinheiro()
                            + "\nStatus: " + listMarinheiros.isStatus()
                            + "\n");
        }
    }
    
    public static void visualizarBarcos() {
        System.out.println("\n--- Lista de Barcos ---");
        for (Barco listBarcos: cadBarcos.getBarcos()) {
            System.out.println("Id do barco: " + listBarcos.getIdBarco()
                        + "\nNome do barco: " + listBarcos.getNomeBarco()
                        + "\nCor do barco: " + listBarcos.getCorBarco()
                        + "\n");
        }
    }
    
    public static void deletarReservas() {
        System.out.println("\n--- Deletar Reserva ---");
        boolean condicao = true;
        do {
            System.out.print("Informe o Id do barco: ");
            short idBarco = ler.nextShort();
            if (cadBarcos.verId(idBarco)) {
                System.out.print("Informe o Id do marinheiro: ");
                short idMarinheiro = ler.nextShort();
                if (cadMarinheiros.verId(idMarinheiro)) {
                    System.out.print("Informe a data da reserva: ");
                    String data = leTexto();
                    if (cadReservas.verReserva(data, idBarco)) {
                        Reserva r = cadReservas.selecionarReserva(data, idBarco, idMarinheiro);
                        System.out.println("\nReserva encontrada."
                                            + "\nData: "+r.getDia()
                                            + "\nBarco: "+cadBarcos.getNomeBarco(idBarco)
                                            + "\nMarinheiro: "+cadMarinheiros.getNomeMarinheiro(idMarinheiro)
                                            + "\n");
                        System.out.print("Deseja realmente deletar esta reserva? 1- Sim | 0- Não");
                        int i = ler.nextInt();
                        if (i == 1) {
                            if (cadReservas.removeReserva(r)) {
                                System.out.println("Reserva deletada com sucesso.\n");
                            } else {
                                System.out.println("Ocorreu um erro ao deletar a reserva.\n");
                            }
                        } else {
                            System.out.println("Operação cancelada.\n");
                        }
                        condicao = false;
                    } else {
                        System.out.println("Reserva não encontrada, Tente novamente!\n");
                    }
                } else {
                    System.out.println("Marinheiro não encontrado. Tente novamente!\n");
                }
            } else {
                if (idBarco == 0) {
                    System.out.println("Cancelando a operação.\n");
                    condicao = false;
                    break;
                } else {
                    System.out.println("Barco não encontrado. Tente novamente!");
                }
            }
        } while(condicao);
    }
    
    public static void atualizarReservas() {
        System.out.println("\n--- Atualizar Reservas ---");
        byte op;
        do {
            System.out.print("1- Atualizar id barco"
                    + "\n2- Atualizar id marinheiro"
                    + "\n3- Atualizar data"
                    + "\n4- Atualizar tudo"
                    + "\n0- Sair"
                    + "Digite uma opção: ");
            op = ler.nextByte();
            switch(op) {
                case 1:
                    System.out.print("\n--- Atualização do id do barco ---"
                            + "\nDigite o id do barco: ");
                    short idBarco = ler.nextShort();
                    if (cadBarcos.verId(idBarco)) {
                        Barco b = cadBarcos.selecionaBarco(idBarco);
                        b.setIdBarco(idBarco);
                    } else {
                    
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Operação cancelada.");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        } while(op != 0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadMarinheiros.mokMarinheiros();
        cadBarcos.mokBarcos();
        cadReservas.mokReservas();
        byte opM = 99;
        do {
            try {
                menuPrincipal();
                opM = ler.nextByte();
            } catch(Exception e) {
                e.printStackTrace();
            }
            switch(opM) {
                case 1:
                    visualizarMarinheiros();
                    break;
                case 2:
                    visualizarBarcos();
                    break;
                case 3:
                    visualizarReservas();
                    break;
                case 4:
                    cadastrarReservas();
                    break;
                case 5:
                    deletarReservas();
                    break;
                case 6:
                    atualizarReservas();
                    break;
                case 0:
                    opM = 0;
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!\n");
            }
        } while(opM != 0);
    }
}
