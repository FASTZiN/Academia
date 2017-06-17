import javax.swing.JTextArea;

public class ImprimirTodoTreino implements GerenciadorTreino {
	JTextArea x;
	ImprimirTodoTreino(JTextArea x){
		this.x = x;
	}
	@Override
	public void imprimirTreino(Exercicio[] exercicios) {
		for(int i = 0; i < exercicios.length; i++){
		}
	}

}
