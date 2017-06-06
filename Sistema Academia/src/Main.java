import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {
	//Definindo algumas "Variaveis"
	private JPanel quadroAluno;
	private JPanel quadroInicio;
	private JFormattedTextField matricula;
	Aluno a;
	JTextArea textArea;
	JScrollPane scrollPane;

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

		addAluno(new Aluno(new Treino[2], "Caio", "00000001"));
		a.setTreino(0, new Treino('A', new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Supino Reto", "5", "5"),
				new Exercicio("Remada Curvada", "5", "5")}));
		a.setTreino(1, new Treino('B', new Exercicio[]{
				new Exercicio("Agachamento", "5", "5"),
				new Exercicio("Desenvolvimento", "5", "5"),
				new Exercicio("Levantamento Terra", "5", "5")}));


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

		//Inicializando
		inicio(quadroInicio);

	}

	//DEFININDO GUI INICIAL
	private void inicio(JPanel inicio_quadro) {
		JLabel panel = new JLabel();
		///Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
		//panel.setIcon(new ImageIcon(img));
		panel.setBounds(268, 119, 263, 237);
		quadroInicio.add(panel);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMatricula.setBounds(259, 444, 123, 30);
		quadroInicio.add(lblMatricula);

		matricula = new JFormattedTextField(mask("########"));
		matricula.setBounds(364, 444, 197, 36);
		quadroInicio.add(matricula);
		matricula.setColumns(8);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(326, 516, 140, 50);
		quadroInicio.add(btnBuscar);
		btnBuscar.setActionCommand("BUSCAR");
		btnBuscar.addActionListener(this);
	}

	private MaskFormatter mask(String m) {
		MaskFormatter f = null;
		try {
			f = new MaskFormatter(m);
			f.setValidCharacters("1234567890");
		} catch (java.text.ParseException e) {
			System.err.println("formatter is bad: " + e.getMessage());
			System.exit(-1);
		}

		return f;
	}

	//Definindo GUI ALUNO
	private void pagina_Aluno(JPanel aluno_quadro) {
		JLabel lblNome = new JLabel("Nome: " + a.getNome());
		lblNome.setBounds(61, 26, 100, 16);
		aluno_quadro.add(lblNome);

		JLabel lblMatricula = new JLabel("Matricula: " + a.getMatriculaAluno());
		lblMatricula.setBounds(61, 67, 200, 16);
		aluno_quadro.add(lblMatricula);

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
		//textArea.append("");
		aluno_quadro.add(textArea);
		aluno_quadro.add(scrollPane);
	}

	void addAluno(Aluno a) {
		this.a = a;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("BUSCAR")) {
			if (matricula.getText().equals(a.getMatriculaAluno())) {
				setContentPane(quadroAluno);
				invalidate();
				validate();
				this.pagina_Aluno(quadroAluno);
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(), "Aluno não matriculado!");
			}

		}

		else if(cmd.equals("Treino A")){
			textArea.setText(null);
			textArea.setText(a.getTreino(0));

		}

		else if(cmd.equals("Treino B")){
			textArea.setText(null);
			textArea.setText(a.getTreino(1));
		}

		else if (cmd.equals("VOLTAR")) {
			setContentPane(quadroInicio);
			invalidate();
			validate();
			this.inicio(quadroInicio);
		}

	}

}
