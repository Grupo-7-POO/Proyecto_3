package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.usuarios.Profesor;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuProfesor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnNewRadioButton;
	private JComboBox<String> comboBox;
	private JLabel lblNewLabel;
	private Profesor usuarioActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MenuProfesor frame = new MenuProfesor();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuProfesor( Profesor profesor ) 
	{
		this.usuarioActual = profesor;
		setTitle("Menu Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Crear Learning Path");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setBounds(6, 32, 159, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Editar Learning Path");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setBounds(6, 58, 159, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Crear Actividad");
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setBounds(6, 84, 127, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Editar Actividad");
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_3.setBounds(6, 111, 127, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Clonar Actividad");
		rdbtnNewRadioButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_4.setBounds(6, 137, 127, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		ButtonGroup opcionesActividades = new ButtonGroup();
		opcionesActividades.add(rdbtnNewRadioButton_4);
		opcionesActividades.add(rdbtnNewRadioButton_3);
		opcionesActividades.add(rdbtnNewRadioButton_2);
		opcionesActividades.add(rdbtnNewRadioButton_1);
		opcionesActividades.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnNewRadioButton_1.addActionListener(this);
		rdbtnNewRadioButton_2.addActionListener(this);
		rdbtnNewRadioButton_3.addActionListener(this);
		rdbtnNewRadioButton_4.addActionListener(this);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Encuesta ", "Examen ", "Quiz", "Recurso Educativo", "Tarea"}));
		comboBox.setBounds(139, 88, 127, 22);
		comboBox.addActionListener( this );
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Acciones");
		lblNewLabel.setBounds(6, 11, 127, 14);
		contentPane.add(lblNewLabel);
		comboBox.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource() == rdbtnNewRadioButton ) // Crear Learning Path
		{
			comboBox.setVisible(false);
			System.out.println("Crear Learning Path");
		}
		else if ( e.getSource() == rdbtnNewRadioButton_1  ) // Editar Learning Path
		{
			comboBox.setVisible(false);
			
		}
		else if ( e.getSource() == rdbtnNewRadioButton_2  ) // Crear Actividad
		{
			comboBox.setVisible(true);
		}
		else if ( e.getSource() == rdbtnNewRadioButton_3  ) // Editar Actividad
		{
			comboBox.setVisible(false);
			
		}
		else if ( e.getSource() == rdbtnNewRadioButton_4  ) // Clonar Actividad
		{
			comboBox.setVisible(false);
		}
		
		if ( e.getSource() == comboBox )
		{
			int actividad = comboBox.getSelectedIndex();
			System.out.println(comboBox.getSelectedIndex());
			switch (actividad)
			{
			case 1: 
					CrearEncuesta crearEncuesta = new CrearEncuesta( usuarioActual );
					crearEncuesta.setVisible(true);
					break;
			case 2: 
					//new CrearExamen();
					break;
			case 3: 
					//new CrearQuiz();
					break;	
			case 4: 
					//new CrearRecursoEducativo();
					break;
			case 5: 
					//new CrearTarea();
					break;
			default:
					break;
			}
		}
		
		
		
	}
}