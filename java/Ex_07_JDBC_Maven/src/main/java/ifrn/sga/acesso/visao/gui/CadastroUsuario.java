package ifrn.sga.acesso.visao.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifrn.sga.acesso.modelo.dao.UsuarioDAO;
import br.ifrn.sga.acesso.modelo.entidade.Usuario;

public class CadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField fieldTag;
	private JTextField fieldCpf;
	private JTextField fieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setResizable(false);
		setTitle("Cadastro de Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 220);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		fieldTag = new JTextField();
		fieldTag.setBounds(69, 70, 218, 20);
		contentPane.add(fieldTag);
		fieldTag.setColumns(10);

		fieldCpf = new JTextField();
		fieldCpf.setBounds(69, 39, 218, 20);
		contentPane.add(fieldCpf);
		fieldCpf.setColumns(10);

		fieldNome = new JTextField();
		fieldNome.setBounds(69, 8, 218, 20);
		contentPane.add(fieldNome);
		fieldNome.setColumns(10);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 11, 49, 14);
		contentPane.add(labelNome);

		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(10, 42, 49, 14);
		contentPane.add(labelCPF);

		JLabel labelTag = new JLabel("TAG:");
		labelTag.setBounds(10, 73, 49, 14);
		contentPane.add(labelTag);

		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		buttonCadastrar.setBounds(49, 135, 114, 23);
		contentPane.add(buttonCadastrar);

		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		buttonLimpar.setBounds(173, 135, 114, 23);
		contentPane.add(buttonLimpar);
	}

	public void limpar() {
		fieldNome.setText("");
		fieldCpf.setText("");
		fieldTag.setText("");
	}

	public void cadastrar() {
		String nome = fieldNome.getText();
		String cpf = fieldCpf.getText();
		String tag = fieldTag.getText();

		if (nome.isBlank()) {
			JOptionPane.showMessageDialog(this, "O nome é um campo obrigatório!", "Nome Vazio",
					JOptionPane.ERROR_MESSAGE);
		} else if (cpf.isBlank()) {
			JOptionPane.showMessageDialog(this, "O CPF é um campo obrigatório!", "CPF Vazio",
					JOptionPane.ERROR_MESSAGE);
		} else if (tag.isBlank()) {
			JOptionPane.showMessageDialog(this, "A tag é um campo obrigatório!", "Tag Vazia",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try (UsuarioDAO dao = new UsuarioDAO()) {
				if (dao.adicionar(new Usuario(0, nome, cpf, Integer.parseInt(tag)))) {
					JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
					limpar();
				} else {
					JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Tag deve ser um campo numérico!", "Tag Inválida",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
