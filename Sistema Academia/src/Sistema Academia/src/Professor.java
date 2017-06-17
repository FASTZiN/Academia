public class Professor {
    Aluno[] alunos = new Aluno[100000];
    private int n;
    Professor(){
    	Treino[] treino_teste = new Treino[2];
		treino_teste[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Desenvolvimento", "5", "5"),
				new Exercicio("Levantamento Terra", "5", "5")});
		treino_teste[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Supino Reto", "5", "5"),
				new Exercicio("Remada Curvada", "5", "5")});
		alunos[0] = new Aluno("Caio",treino_teste, "00000001");
		Treino[] treino_teste2 = new Treino[2];
		treino_teste2[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento 1", "5", "5"),
				new Exercicio("Desenvolvimento 2", "5", "5"),
				new Exercicio("Levantamento Terra 3", "5", "5")});
		treino_teste2[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento 1", "5", "5"),
				new Exercicio("Supino Reto 2", "5", "5"),
				new Exercicio("Remada Curvada 3", "5", "5")});
		alunos[1] = new Aluno("Jorge",treino_teste2, "00000002");
		Treino[] treino_teste3 = new Treino[2];
		treino_teste3[0] = new Treino(new Exercicio[]{
				new Exercicio("Agachamento 12", "5", "5"),
				new Exercicio("Desenvolvimento 22", "5", "5"),
				new Exercicio("Levantamento Terra 32", "5", "5")});
		treino_teste3[1] = new Treino (new Exercicio[]{
				new Exercicio("Agachamento 12", "5", "5"),
				new Exercicio("Supino Reto 22", "5", "5"),
				new Exercicio("Remada Curvada 32", "5", "5")});
		alunos[2] = new Aluno("Jorge",treino_teste2, "00000003");
		n = 3;
		
    }
    public void addAluno(Aluno x){
    	  alunos[n] = x;
    	    n = n + 1;
    }
    void removeAluno(Aluno x) { 
        removeAluno(indexOf(x));
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
      }
}