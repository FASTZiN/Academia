import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Main extends JFrame implements ActionListener {
	//Definindo algumas "Variaveis"
	private JPanel quadroAluno;
	private JPanel quadroInicio;
	private JPanel quadroProf;
	private JPanel senhaProf;
	private JPanel quadroAddAluno;
	private JPanel quadroRemoveAluno;
	private JPanel quadroMatTreino;
	private JPanel quadroselTreinoEExs;
	private JPanel quadroAddExs;
	private JLabel lblNome = new JLabel();
	private JLabel lblMatricula = new JLabel();
	private JComboBox comboBox;
	private JFormattedTextField matricula, addNome, addSobrenome,removeMatricula, matTreino, numeroExs,nomeExs, qntdSeries, qntdRepeticoes, selTreino;
	private JPasswordField senha;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private int width = 800;
	private int height = 700;
	private String x = null;
	private ImprimirExs imprimir;
	private Professor prof = new Professor();
	private char[] input = {'0','0','0','0'};
	private String[] selecionaTreino = {"TREINO A", "TREINO B", "TREINO C"};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Main() {

		//Definindo confgurações JFrame
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		//Quadro Inicio
		quadroInicio = new JPanel();
		quadroInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		quadroInicio.setLayout(null);
		setContentPane(quadroInicio);

		//Quadro Aluno

		quadroAluno = new JPanel();
		quadroAluno.setBorder(new EmptyBorder(5, 5, 5, 5));
		quadroAluno.setLayout(null);
		
		//Quadro Professor
		quadroProf = new JPanel();
		quadroProf.setBorder(new EmptyBorder(5,5,5,5));
		quadroProf.setLayout(null);

		//Quadro Senha
		senhaProf = new JPanel();
		senhaProf.setBorder(new EmptyBorder(5,5,5,5));
		senhaProf.setLayout(null);
		
		//Quadro Add Aluno
		
		quadroAddAluno = new JPanel();
		quadroAddAluno.setBorder(new EmptyBorder(5,5,5,5));
		quadroAddAluno.setLayout(null);
		
		//Quadro Remove Aluo
		
		quadroRemoveAluno = new JPanel();
		quadroRemoveAluno.setBorder(new EmptyBorder(5,5,5,5));
		quadroRemoveAluno.setLayout(null);
		
		//Quadro Mat Add Treino
		quadroMatTreino = new JPanel();
		quadroMatTreino.setBorder(new EmptyBorder(5,5,5,5));
		quadroMatTreino.setLayout(null);
		
		//Quadro Seleciona Treino e Exs
		quadroselTreinoEExs = new JPanel();
		quadroselTreinoEExs.setBorder(new EmptyBorder(5,5,5,5));
		quadroselTreinoEExs.setLayout(null);
		
		//Quadro add Exs
		quadroAddExs = new JPanel();
		quadroAddExs.setBorder(new EmptyBorder(5,5,5,5));
		quadroAddExs.setLayout(null);
				
		//Inicializando
		inicio(quadroInicio);

	}

	//DEFININDO GUI INICIAL
	private void inicio(JPanel inicio_quadro) {
		JLabel panel = new JLabel();
		Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
		panel.setIcon(new ImageIcon(img));
		panel.setBounds(268, 119, 263, 237);
		quadroInicio.add(panel);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMatricula.setBounds(259, 444, 123, 30);
		quadroInicio.add(lblMatricula);

		
		matricula = new JFormattedTextField(mask());
		matricula.setBounds(364, 444, 197, 36);
		matricula.setText(null);
		quadroInicio.add(matricula);
		matricula.setColumns(8);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(326, 516, 140, 50);
		quadroInicio.add(btnBuscar);
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.addActionListener(this);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.setBounds(width/1000,height/1000,70,20);
		quadroInicio.add(adminBtn);
		adminBtn.setActionCommand("Admin");
		adminBtn.addActionListener(this);
	}

	private MaskFormatter mask() {
		MaskFormatter f = null;
		try {
			f = new MaskFormatter("########");
			f.setValidCharacters("1234567890");
		} catch (java.text.ParseException e) {
			System.err.println("formatter is bad: " + e.getMessage());
			System.exit(-1);
		}

		return f;
	}
	
	private MaskFormatter selExs() {
		MaskFormatter f = null;
		try {
			f = new MaskFormatter("#");
			f.setValidCharacters("0123456789");
		} catch (java.text.ParseException e) {
			System.err.println("formatter is bad: " + e.getMessage());
			System.exit(-1);
		}

		return f;
	}
	//Resetando Valores
	private void resetaAlgumasCoisas(){
		lblNome.setText(null);
		lblMatricula.setText(null);;
	}

	//Definindo GUI ALUNO
	private void pagina_Aluno(JPanel aluno_quadro) {
		//lblNome = new JLabel();
		lblNome.setBounds(61, 26, 100, 16);
		aluno_quadro.add(lblNome);

		//lblMatricula = new JLabel();
		lblMatricula.setBounds(61, 67, 200, 16);
		aluno_quadro.add(lblMatricula);
		prof.imprimirDados(lblNome, lblMatricula);


		JButton btnTreinoA = new JButton("Treino A");
		btnTreinoA.setBounds(108, 132, 117, 29);
		aluno_quadro.add(btnTreinoA);
		btnTreinoA.setActionCommand("Treino A");
		btnTreinoA.addActionListener(this);

		JButton btnTreinoB = new JButton("Treino B");
		btnTreinoB.setBounds(349, 132, 117, 29);
		aluno_quadro.add(btnTreinoB);
		btnTreinoB.setActionCommand("Treino B");
		btnTreinoB.addActionListener(this);

		JButton btnTreinoC = new JButton("Treino C");
		btnTreinoC.setBounds(588, 132, 117, 29);
		btnTreinoC.setActionCommand("Treino C");
		aluno_quadro.add(btnTreinoC);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(349, 626, 117, 29);
		aluno_quadro.add(btnVoltar);
		btnVoltar.setActionCommand("VOLTAR");
		btnVoltar.addActionListener(this);


		textArea = new JTextArea(5, 300);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		textArea.setBounds(150, 200, 500, 400);
		aluno_quadro.add(textArea);
		aluno_quadro.add(scrollPane);


	}
	
	//GUI Senha Prof
		private void senhaProf(JPanel senhaProf){
			JLabel panel = new JLabel();
			Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
			panel.setIcon(new ImageIcon(img));
			panel.setBounds(268, 119, 263, 237);
			senhaProf.add(panel);
			
			JLabel lblSenha = new JLabel("Senha: ");
			lblSenha.setBounds(width/2-150,height/2,200,30);
			senhaProf.add(lblSenha);

			this.senha = new JPasswordField();
			senha.setBounds(width/2-100,height/2,200,30);
			senhaProf.add(senha);

			JButton btnSenha = new JButton("Enter");
			btnSenha.setBounds(width/2+100,height/2,100,30);
			senhaProf.add(btnSenha);
			btnSenha.setActionCommand("Enter");
			btnSenha.addActionListener(this);

			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(349, 626, 117, 29);
			senhaProf.add(btnVoltar);
			btnVoltar.setActionCommand("VOLTAR");
			btnVoltar.addActionListener(this);

		}

		//Definindo GUI PROF
		private void paginaProf(JPanel quadroProf) {
			JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
			lblAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblAdministrador.setBounds(261, 57, 257, 41);
			quadroProf.add(lblAdministrador);
			
			JLabel lblSelecioneAOpao = new JLabel("SELECIONE A OPÇÃO DESEJADA A SEGUIR:");
			lblSelecioneAOpao.setBounds(65, 226, 300, 16);
			quadroProf.add(lblSelecioneAOpao);
			
			JButton btnAdiocionarAluno = new JButton("ADICIONAR ALUNO");
			btnAdiocionarAluno.setBounds(129, 312, 185, 29);
			btnAdiocionarAluno.setActionCommand("ADICIONAR ALUNO");
			quadroProf.add(btnAdiocionarAluno);
			btnAdiocionarAluno.addActionListener(this);
			
			JButton btnRemoverAluno = new JButton("REMOVER ALUNO");
			btnRemoverAluno.setBounds(129, 435, 185, 29);
			quadroProf.add(btnRemoverAluno);
			btnRemoverAluno.setActionCommand("REMOVER ALUNO");
			btnRemoverAluno.addActionListener(this);
			
			JButton btnCriarTreino = new JButton("CRIAR TREINO");
			btnCriarTreino.setBounds(436, 312, 185, 29);
			quadroProf.add(btnCriarTreino);
			btnCriarTreino.setActionCommand("CRIAR TREINO");
			btnCriarTreino.addActionListener(this);
			
			JButton btnAlterarTreino = new JButton("ALTERAR TREINO");
			btnAlterarTreino.setBounds(436, 435, 185, 29);
			quadroProf.add(btnAlterarTreino);
			
			JButton btnListaDeAlunos = new JButton("LISTA DE ALUNOS");
			btnListaDeAlunos.setBounds(289, 538, 185, 29);
			quadroProf.add(btnListaDeAlunos);
			
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setBounds(349, 626, 117, 29);
			quadroProf.add(btnVoltar);
			btnVoltar.setActionCommand("VOLTAR");
			btnVoltar.addActionListener(this);
		}
		
		//Definindo GUI Add ALUNO
		
		private void paginaAddAluno(JPanel quadroAddAluno){
			JLabel lblAdcionandoUmAluno = new JLabel("ADICIONANDO UM ALUNO");
			lblAdcionandoUmAluno.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblAdcionandoUmAluno.setBounds(215, 135, 334, 32);
			quadroAddAluno.add(lblAdcionandoUmAluno);
			
			JLabel lblParaAdiconarUm = new JLabel("PARA ADICONAR UM ALUNO AO SISTEMA, BASTA COLOCAR O NOME, SOBRENOME DO NOVO ALUNO");
			lblParaAdiconarUm.setBounds(73, 226, 648, 16);
			quadroAddAluno.add(lblParaAdiconarUm);
			
			JLabel lblNome = new JLabel("NOME:");
			lblNome.setBounds(138, 341, 61, 16);
			quadroAddAluno.add(lblNome);
			
			addNome = new JFormattedTextField();
			addNome.setBounds(187, 336, 477, 26);
			quadroAddAluno.add(addNome);
			addNome.setColumns(10);
			
			JLabel lblSobrenome = new JLabel("SOBRENOME:");
			lblSobrenome.setBounds(138, 434, 81, 16);
			quadroAddAluno.add(lblSobrenome);
			
			addSobrenome = new JFormattedTextField();
			addSobrenome.setBounds(231, 429, 433, 26);
			quadroAddAluno.add(addSobrenome);
			addSobrenome.setColumns(10);
			
			JButton btnAdicionar = new JButton("ADICIONAR");
			btnAdicionar.setBounds(336, 619, 117, 29);
			quadroAddAluno.add(btnAdicionar);
			btnAdicionar.setActionCommand("ADICIONAR");
			btnAdicionar.addActionListener(this);
			
			JLabel lblAoClicarEm = new JLabel("AO CLICAR EM ADICIONAR, UMA MENSAGEM SERÁ EXIBIDA INFORMANDO SE O ALUNO FOI ADIOCIONADO COM SUCESSO");
			lblAoClicarEm.setBounds(20, 531, 763, 32);
			quadroAddAluno.add(lblAoClicarEm);
		}
	
	//GUI REMOVE ALUNO
		private void paginaRemoveAluno(){
			JLabel lblRemoDeAluno = new JLabel("REMOÇÃO DE ALUNO DO SISTEMA");
			lblRemoDeAluno.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblRemoDeAluno.setBounds(176, 53, 441, 32);
			quadroRemoveAluno.add(lblRemoDeAluno);
			
			JLabel lblParaRemoverO = new JLabel("PARA REMOVER O ALUNO, BASTA COLOCAR A SUA MATRICULA E CLICAR NO BOTÃO REMOVER.");
			lblParaRemoverO.setBounds(104, 174, 602, 54);
			quadroRemoveAluno.add(lblParaRemoverO);
			
			JLabel lblMatricula = new JLabel("MATRICULA:");
			lblMatricula.setBounds(264, 374, 92, 16);
			quadroRemoveAluno.add(lblMatricula);
			
			removeMatricula = new JFormattedTextField(this.mask());
			removeMatricula.setBounds(368, 369, 130, 26);
			quadroRemoveAluno.add(removeMatricula);
			removeMatricula.setColumns(10);
			
			JButton btnRemover = new JButton("REMOVER");
			btnRemover.setBounds(308, 534, 117, 29);
			quadroRemoveAluno.add(btnRemover);
			btnRemover.setActionCommand("REMOVER");
			btnRemover.addActionListener(this);
			
			JButton btnVoltar = new JButton("VOLTAR");
			btnVoltar.setBounds(308, 632, 117, 29);
			quadroRemoveAluno.add(btnVoltar);
			btnVoltar.setActionCommand("VOLTAR");
			btnVoltar.addActionListener(this);
			
		}
		
		//GUI RECEBE MATRICULA, ADD TREINO
		
	public void matAddTreino(){
		JLabel lblAdic = new JLabel("ADICINANDO NOVO TREINO");
		lblAdic.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblAdic.setBounds(219, 62, 364, 30);
		quadroMatTreino.add(lblAdic);
		
		JLabel lblNewLabel = new JLabel("Qual a matriucla do aluno que se deseja alterar o treino?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(150, 220, 469, 16);
		quadroMatTreino.add(lblNewLabel);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMatricula.setBounds(263, 325, 107, 16);
		quadroMatTreino.add(lblMatricula);
		
		matTreino = new JFormattedTextField(mask());
		matTreino.setBounds(349, 321, 99, 26);
		quadroMatTreino.add(matTreino);
		matTreino.setColumns(10);
		
		JButton btnAvancar = new JButton("AVANÇAR");
		btnAvancar.setBounds(286, 463, 117, 29);
		quadroMatTreino.add(btnAvancar);
		btnAvancar.setActionCommand("AVANCAR SELECAO ");
		btnAvancar.addActionListener(this);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(286, 643, 117, 29);
		quadroMatTreino.add(btnVoltar);
	}
	
		//GUI PAGINA PEGA TREINO E NUMERO DE EXS
	public void selTreinoEExs(){
		selTreino = new JFormattedTextField();
		selTreino.setBounds(307, 251, 139, 27);
		quadroselTreinoEExs.add(selTreino);
		
		
		JLabel addNovoTreino = new JLabel("ADICIONANDO UM NOVO TREINO");
		addNovoTreino.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		addNovoTreino.setBounds(186, 55, 404, 27);
		quadroselTreinoEExs.add(addNovoTreino);
		
		JLabel lblSelecioneEmQual = new JLabel("SELECIONE EM QUAL SLOT DE TREINO O NOVO TREINO SERÁ ARMAZENADO");
		lblSelecioneEmQual.setBounds(147, 162, 486, 21);
		quadroselTreinoEExs.add(lblSelecioneEmQual);
		
		JLabel lblSelecioneQuantosExercicios = new JLabel("SELECIONE QUANTOS EXERCICIOS OS TREINO POSSUI");
		lblSelecioneQuantosExercicios.setBounds(203, 340, 339, 16);
		quadroselTreinoEExs.add(lblSelecioneQuantosExercicios);
		
		numeroExs = new JFormattedTextField(selExs());
		numeroExs.setBounds(316, 417, 130, 26);
		quadroselTreinoEExs.add(numeroExs);
		numeroExs.setColumns(1);
		
		JButton btnAvanar = new JButton("AVANÇAR");
		btnAvanar.setBounds(316, 507, 117, 29);
		quadroselTreinoEExs.add(btnAvanar);
		btnAvanar.setActionCommand("AVANCAR ADD TREINO");
		btnAvanar.addActionListener(this);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(316, 643, 117, 29);
		quadroselTreinoEExs.add(btnVoltar);
	}
	//GUI PAGINA ADD EXERCICIO
	public void addExs(){
		JLabel lblAdicionadoExerciciosAo = new JLabel("ADICIONADO EXERCICIOS AO TREINO");
		lblAdicionadoExerciciosAo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblAdicionadoExerciciosAo.setBounds(149, 82, 452, 30);
		quadroAddExs.add(lblAdicionadoExerciciosAo);
		
		JLabel lblNomeDoExercicio = new JLabel("NOME DO EXERCICIO:");
		lblNomeDoExercicio.setBounds(80, 288, 141, 16);
		quadroAddExs.add(lblNomeDoExercicio);
		
		nomeExs = new JFormattedTextField();
		nomeExs.setBounds(233, 283, 326, 26);
		quadroAddExs.add(nomeExs);
		nomeExs.setColumns(10);
		
		JLabel lblSeries = new JLabel("SERIES:");
		lblSeries.setBounds(171, 328, 61, 16);
		quadroAddExs.add(lblSeries);
		
		qntdSeries = new JFormattedTextField(selExs());
		qntdSeries.setBounds(233, 323, 130, 26);
		quadroAddExs.add(qntdSeries);
		qntdSeries.setColumns(10);
		
		JLabel lblRepeties = new JLabel("REPETIÇÕES:");
		lblRepeties.setBounds(134, 370, 86, 16);
		quadroAddExs.add(lblRepeties);
		
		qntdRepeticoes = new JFormattedTextField();
		qntdRepeticoes.setBounds(233, 365, 130, 26);
		quadroAddExs.add(qntdRepeticoes);
		qntdRepeticoes.setColumns(10);
		
		JLabel lblAdicioneONome = new JLabel("ADICIONE O NOME DO EXERCICIO, AS QUANTIDADE DE SERIES E REPETIÇÕES:");
		lblAdicioneONome.setBounds(133, 183, 496, 16);
		quadroAddExs.add(lblAdicioneONome);
		
		JLabel lblNumeroDoExs = new JLabel("NUMERO DO EXS:");
		lblNumeroDoExs.setBounds(149, 239, 116, 16);
		quadroAddExs.add(lblNumeroDoExs);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(289, 500, 117, 29);
		quadroAddExs.add(btnAdd);
		btnAdd.setActionCommand("ADD EXS");
		btnAdd.addActionListener(this);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(349, 626, 117, 29);
		quadroAddExs.add(btnVoltar);
		btnVoltar.setActionCommand("VOLTAR");
		btnVoltar.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//x = matricula.getText();
		if(cmd.equals("BUSCAR")){
			if(prof.matriculaExiste(matricula) == false){
			JOptionPane.showMessageDialog(new JFrame(), "Aluno não matriculado!");
			matricula.setText(null);}
		else {
			this.pagina_Aluno(quadroAluno);
			setContentPane(quadroAluno);
			invalidate();
			validate();
			prof.selecionaMatriculaSelecionada(matricula);
			System.out.println(matricula.getText());
		}
	}
		else if(cmd.equals("Treino A")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			prof.imprimirTreinoAluno(0, matricula, imprimir);

		}

		else if(cmd.equals("Treino B")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			prof.imprimirTreinoAluno(1, matricula, imprimir);

		}
		else if(cmd.equals("Treino C")){
			textArea.setText(null);
			imprimir = new ImprimirExs(textArea);
			prof.imprimirTreinoAluno(2, matricula, imprimir);

		}
		else if(cmd.equals("Admin")){
			setContentPane(senhaProf);
			invalidate();
			validate();
			this.senhaProf(senhaProf);
		}
		else if(cmd.equals("ADICIONAR ALUNO")){
			setContentPane(quadroAddAluno);
			invalidate();
			validate();
			this.paginaAddAluno(quadroAddAluno);
		}
		else if(cmd.equals("Enter")){
			//input = senha.getPassword();

			if(prof.SenhaCorreta(senha)) {
				setContentPane(quadroProf);
				invalidate();
				validate();
				this.paginaProf(quadroProf);
				System.out.println(senha.getPassword());
				senha.setText(null);
			} else{JOptionPane.showMessageDialog(new JPanel(),"SENHA ERRADA");
				System.out.println(senha.getPassword());
			}
			
		}

		else if (cmd.equals("VOLTAR")) {
			setContentPane(quadroInicio);
			invalidate();
			validate();
			this.resetaAlgumasCoisas();
			matricula.setText(null);
		}
		else if(cmd.equals("ADICIONAR")){
			prof.addAluno(addNome, addSobrenome);
			setContentPane(quadroProf);
			invalidate();
			validate();
			addNome.setText(null);
			addSobrenome.setText(null);
		}
		else if(cmd.equals("REMOVER ALUNO")){
			setContentPane(quadroRemoveAluno);
			invalidate();
			validate();
			this.paginaRemoveAluno();
			prof.imprimirAlunos();
		}
		else if(cmd.equals("REMOVER")){
			if(prof.matriculaExiste(removeMatricula)){
			prof.removeAluno(removeMatricula);
			JOptionPane.showMessageDialog(new JFrame(), "Aluno removido do sistema");
			prof.imprimirAlunos();
			setContentPane(quadroProf);
			invalidate();
			validate();
			removeMatricula.setText(null);
			}else{
				JOptionPane.showMessageDialog(new JFrame(), "Matricula não encontada");
				removeMatricula.setText(null);
			}
		}
		else if(cmd.equals("CRIAR TREINO")){
			setContentPane(quadroMatTreino);
			invalidate();
			validate();
			this.matAddTreino();
		}
		else if(cmd.equals("AVANCAR SELECAO ")){
			setContentPane(quadroselTreinoEExs);
			invalidate();
			validate();
			this.selTreinoEExs();
		}
		else if(cmd.equals("AVANCAR ADD TREINO")){
			setContentPane(quadroAddExs);
			invalidate();
			validate();
			this.addExs();
		}
		else if(cmd.equals("ADD EXS")){
			prof.criarNovoExs(matTreino, selTreino, numeroExs, nomeExs, qntdSeries, qntdRepeticoes);
		}

	}

}