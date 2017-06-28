import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Professor {
	private int mat_selecionada;
	Aluno[] alunos = new Aluno[100000];
    private int n;
    private Aluno x;
    
    criarNovaSerie eg = new criarNovaSerie();
    Professor(){
    	Treino[] treino_teste = new Treino[2];
		treino_teste[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Desenvolvimento", "5", "5"),
				new Exercicio("Levantamento Terra", "5", "5"), null, null, null, null, null});
		treino_teste[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Supino Reto", "5", "5"),
				new Exercicio("Remada Curvada", "5", "5"), null, null, null, null, null});
		alunos[0] = new Aluno("Caio",treino_teste, "00000001");
		Treino[] treino_teste2 = new Treino[2];
		treino_teste2[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento 1", "5", "5"),
				new Exercicio("Desenvolvimento 2", "5", "5"),
				new Exercicio("Levantamento Terra 3", "5", "5"), null, null, null, null, null});
		treino_teste2[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento 1", "5", "5"),
				new Exercicio("Supino Reto 2", "5", "5"),
				new Exercicio("Remada Curvada 3", "5", "5"), null, null, null, null, null});
		alunos[1] = new Aluno("Jorge",treino_teste2, "00000002");
		Treino[] treino_teste3 = new Treino[2];
		treino_teste3[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento 12", "5", "5"),
				new Exercicio("Desenvolvimento 22", "5", "5"),
				new Exercicio("Levantamento Terra 32", "5", "5"), null, null, null, null, null});
		treino_teste3[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento 12", "5", "5"),
				new Exercicio("Supino Reto 22", "5", "5"),
				new Exercicio("Remada Curvada 32", "5", "5"), null, null, null, null, null});
		alunos[2] = new Aluno("Rosvelter",treino_teste2, "00000003");
		n = 3;
		
    }
    public void addAluno(JFormattedTextField nome, JFormattedTextField sobrenome){
    	  alunos[n] = this.retornaNovoAluno(nome,sobrenome);
    	    n = n + 1;
    	  for(int i = 0; i < n;i++){
    		  alunos[i].imprimirNomeP();
    	  }
    }
    void removeAluno(JFormattedTextField matricula) {
    	//Isto aq d certo, mas ta errado!!!!!!!
    	//Aluno x = this.alunoPorMatricula(matricula);
    	for(int i = 0; i < n; i++){
  		  if(this.matriculaExiste(matricula) == true){
  			   //x = alunos[i];
  			removeAluno(indexOf(alunos[i]));
  		  }
  	  }
        //removeAluno(indexOf());
      }
      private void removeAluno(int k) {
        if (k < 0) return;
        n = n - 1;
        alunos[k] = alunos[n];
        return;
      }
      private int indexOf(Aluno x) {
        for(int i = 0; i < n; i++) {
          if(alunos[i] == x) return i;
        }
        return -1;
      }
      
       void imprimirAlunos(){
    	   for(int i = 0; i < n;i++){
    		   alunos[i].imprimirNomeP();
    	   }
      }
       

      private Aluno retornaNovoAluno(JFormattedTextField nome, JFormattedTextField sobrenome){
    	  String addNome, addSobrenome, addMatricula;
    	  addNome = nome.getText();
    	  addSobrenome = sobrenome.getText();
    	  
    	  
    	  Aluno x = new Aluno(addNome,null,"000000004");  
    	  return x;
      }
      
      //Tirar isso dessa classe 
      public boolean SenhaCorreta(JPasswordField x){
    	  String c = new String("abcd1234");
    	  boolean isCorrect = true;
  		String correctPassword = "abcd1234";

  		if (correctPassword.equals(c)) {
  			isCorrect = true;
  		} else {
  			isCorrect = false;
  		}

  		return isCorrect;
      }
      //Isso tbm...
      public boolean matriculaExiste(JFormattedTextField x){
    	  String matricula_esc = x.getText();
    	  boolean existe = false;
    	  for(int i = 0; i< n; i++){
    		if(alunos[i].verificarMatricula(x.getText())){
    			existe = true;
    			mat_selecionada = i;
    		}
    	  }
    	  return existe;
      }
      
      public void selecionaMatriculaSelecionada(JFormattedTextField x){
    	  String matricula_esc = x.getText();
    	  for(int i = 0; i< n; i++){
    		if(alunos[i].verificarMatricula(matricula_esc)){
    			mat_selecionada = i;
    		}
    	  }
      }
      
      public void criarNovoExs(JFormattedTextField matricula, JFormattedTextField x_treino,JFormattedTextField qtsExs, JFormattedTextField exs, JFormattedTextField serie, JFormattedTextField repeticoes){
  		  if(this.matriculaExiste(matricula) == true){
  			alunos[mat_selecionada].criarNovosExs(x_treino, eg, qtsExs, exs, serie, repeticoes);
      	  }
      }
      
      public void imprimirDados(JLabel i_nome, JLabel i_matricula ){
    	  alunos[mat_selecionada].mostrarNome(i_nome);
    	  alunos[mat_selecionada].mostrarMatriculaAluno(i_matricula);
      }
      
      public void imprimirTreinoAluno(int posTreino, JFormattedTextField matricula, ImprimirExs imprimir){
    	  alunos[mat_selecionada].imprimirTreinamento(posTreino, imprimir);
      }
      
      
      
      
      
}