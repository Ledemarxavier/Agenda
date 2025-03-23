package agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import compromisso.Compromisso;

public class Agenda {

	public List<Compromisso> compromissos = new ArrayList<>(); // Cria uma lista chamada compromissos para armazenar os compromissos.
	
	public Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner chamado scanner para ler entradas do usuário a partir do console.
	
	public void criarCompromisso() {
		System.out.printf("Digite a descrição: ");
		String descricao = scanner.nextLine();
		System.out.print("Digite a data (dd/MM/yyyy): ");
		String dataStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formata a data inserida pelo usuário usando o padrão "dd/MM/yyyy".
		LocalDate data = LocalDate.parse(dataStr, formatter);		
		compromissos.add(new Compromisso(descricao, data)); //Cria um novo objeto Compromisso com a descrição e data fornecidas.
		System.out.printf("Compromisso adicionado!");
	}
	
	public void listarCompromissos() {
	        if (compromissos.isEmpty()) { //Verifica se a lista compromissos está vazia.
	            System.out.println("Nenhum compromisso cadastrado.");
	        } else {
	            System.out.println("\nLista de Compromissos:");
	            for (Compromisso c : compromissos) {
	                System.out.println(c);
	            }
	        }
	    }
	
	public void listarCompromissosFuturos() {                            
        LocalDate hoje = LocalDate.now(); //Obtém a data atual.
        System.out.print("Quantos dias à frente deseja listar?: ");
        int dias = scanner.nextInt();
        scanner.nextLine();

        LocalDate limite = hoje.plusDays(dias); //Calcula a data limite para a listagem de compromissos.
        System.out.println("\nCompromissos futuros:");
        for (Compromisso c : compromissos) {  
            if (!c.getData().isBefore(hoje) && !c.getData().isAfter(limite)) { // Verifica se o compromisso está dentro do período especificado
                System.out.println(c);
            }
        }
    }

    public void editarCompromisso() {
    	listarCompromissos();
        if (compromissos.isEmpty()) 
        	return;
        System.out.print("Informe a descrição do compromisso que deseja editar: ");
        String descricao = scanner.nextLine();
        for (Compromisso c : compromissos) {
            if (c.getDescricao().equalsIgnoreCase(descricao)) {  // Verifica se a descrição existe (ignora maiúsculas e minúsculas)
                System.out.print("Nova descrição: ");
                c.setDescricao(scanner.nextLine());  // Atualiza a descrição
                System.out.print("Nova data (dd/MM/yyyy): ");
                String dataStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                c.setData(LocalDate.parse(dataStr, formatter));
                System.out.println("Compromisso atualizado!");
                return;
            }
        }
        System.out.println("Compromisso não encontrado.");
    }

    public void removerCompromisso() {
    	listarCompromissos();
        if (compromissos.isEmpty()) return;
        System.out.print("Informe a descrição do compromisso que deseja remover: ");
        String descricao = scanner.nextLine();
        compromissos.removeIf(c -> c.getDescricao().equalsIgnoreCase(descricao)); // Remove o compromisso caso a descrição exista (ignora maiúsculas e minúsculas)
        System.out.println("Compromisso removido! ");
    }
}

