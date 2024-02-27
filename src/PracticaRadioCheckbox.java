import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class VentanaPrincipal extends JFrame implements ActionListener{
	
	//Atributos------------------------------------------------------------------------------------
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	ButtonGroup bg = new ButtonGroup();
	Conversor_Distancia cd = new Conversor_Distancia();
	
	JLabel txtIng_Km;
	JCheckBox checkTodos;
	JRadioButton radioMillas, radioPies, radioPulgadas;
	JTextField cajaKm, cajaMillas, cajaPies, cajaPulgadas;
	
	//Constructor(es)------------------------------------------------------------------------------
	public VentanaPrincipal() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Eventos_Conversor");
		setVisible(true);
		
		txtIng_Km = new JLabel("-------------- Ingresa Kilometros --------------");
		agregarComponente(txtIng_Km, 0, 0, 2, 1);

		checkTodos = new JCheckBox("<<< TODOS >>>");
		agregarComponente(checkTodos, 0, 2, 2, 1);
		checkTodos.addActionListener(this);
		
		radioMillas = new JRadioButton("Millas");
		agregarComponente(radioMillas, 0, 3, 1, 1);
		bg.add(radioMillas);
		radioMillas.addActionListener(this);
		
		radioPies = new JRadioButton("Pies");
		agregarComponente(radioPies, 0, 4, 1, 1);
		bg.add(radioPies);
		radioPies.addActionListener(this);
		
		radioPulgadas = new JRadioButton("Pulgadas");
		agregarComponente(radioPulgadas, 0, 5, 1, 1);
		bg.add(radioPulgadas);
		radioPulgadas.addActionListener(this);
		
		cajaKm = new JTextField("70");
		agregarComponente(cajaKm, 0, 1, 2, 1);
		cajaKm.addActionListener(this);
		
		cajaMillas = new JTextField();
		agregarComponente(cajaMillas, 1, 3, 1, 1);
		cajaMillas.setEditable(false);
		
		cajaPies = new JTextField();
		agregarComponente(cajaPies, 1, 4, 1, 1);
		cajaPies.setEditable(false);
		
		cajaPulgadas = new JTextField();
		agregarComponente(cajaPulgadas, 1, 5, 1, 1);
		cajaPulgadas.setEditable(false);
		
		pack();
		setLocationRelativeTo(null);
		
	}
	
	//Otros metodos--------------------------------------------------------------------------------
	public void agregarComponente(JComponent c, int x, int y, int w, int h){
		
		gbc.gridx = x;
		gbc.gridy =y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		gbl.setConstraints(c, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(c);
		
	}//Metodo

	@Override
	public void actionPerformed(ActionEvent e) {
		double numero = 0;
		
		try {
			
			numero = Double.parseDouble( cajaKm.getText());
			
			if( numero >= 0 ) {
				
				if(e.getSource() == checkTodos) {
					
					if(checkTodos.isSelected()) {
						
						cajaMillas.setText( String.valueOf( cd.millas( Double.parseDouble( cajaKm.getText() ) )  ) );
						cajaPies.setText( String.valueOf( cd.pies( Double.parseDouble( cajaKm.getText() ) ) ) );
						cajaPulgadas.setText( String.valueOf( cd.pulgadas( Double.parseDouble( cajaKm.getText() ) ) ) );
						
					}else {
						
						cajaMillas.setText("");
						cajaPies.setText("");
						cajaPulgadas.setText("");
				
					}

				}else if(e.getSource() == radioMillas) {
					
					cajaMillas.setText( String.valueOf( cd.millas( Double.parseDouble( cajaKm.getText() ) )  ) );
					cajaPies.setText("");
					cajaPulgadas.setText("");
					
				}else if(e.getSource() == radioPies) {
					
					cajaPies.setText( String.valueOf( cd.pies( Double.parseDouble( cajaKm.getText() ) ) ) );
					cajaMillas.setText("");
					cajaPulgadas.setText("");
					
				}else if(e.getSource() == radioPulgadas) {
					
					cajaPulgadas.setText( String.valueOf( cd.pulgadas( Double.parseDouble( cajaKm.getText() ) ) ) );
					cajaPies.setText("");
					cajaMillas.setText("");
					
				}
				
			}else {
				
				JOptionPane.showMessageDialog(getContentPane(), "Ingreso distancias negrativas");
				
			}

			
		}catch (NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(getContentPane(), "SOLO NUMEROS", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}	
}

public class PracticaRadioCheckbox {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				new VentanaPrincipal();
				
			}
			
		}
		
		);
		
	}

}
