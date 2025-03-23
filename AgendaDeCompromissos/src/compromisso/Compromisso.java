package compromisso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compromisso {
	String descricao;
	LocalDate data;
	
	// Construtor da classe, inicializa a descrição e a data do compromisso
	public Compromisso(String descricao,LocalDate data) {
		this.descricao = descricao;
		this.data = data;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		public LocalDate getData() {
			return data;
		}
		
		public void setData(LocalDate data) {
			this.data = data;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		// Método toString sobrescrito para exibir o compromisso de forma formatada
		@Override
		public String toString() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	     // Retorna uma string representando o compromisso no formato data descrição
		return "[" + data.format(formatter) + "] " + descricao;
		}
}
