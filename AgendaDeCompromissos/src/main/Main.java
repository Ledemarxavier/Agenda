package main;

import java.util.Scanner;

import agenda.Agenda;
import menu.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Agenda agenda = new Agenda();
		while(true) {
			Menu.exibirMenu(); // Chama o metodo que exibe o menu
			int opcao = scanner.nextInt();
			
			switch(opcao) {
			
            case 1:
                agenda.criarCompromisso();
                break;
            case 2:
                agenda.listarCompromissosFuturos();
                break;
            case 3:
                agenda.editarCompromisso();
                break;
            case 4:
                agenda.removerCompromisso();
                break;
            case 0:
                System.out.println("Saindo...");
                scanner.close();  // Limpa o buffer do scanner
                return;
            default:
                System.out.println("Opção inválida!");
			}		
		}
	}
}


