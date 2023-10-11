/*
 *			Código JAVA para gerar uma lista de números aleatórios em ordem crescente
 *			de acordo com os critérios a ser definidos pelo usuário
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class RandomNumbers
{	
	private JTextField t1, t2;
	private JTextArea a1 = null;	
	private PageFormat pf = null;
	public Random r = new Random();
	int limit = 0;
	int number = 0;

	public List<Integer> numbers = new ArrayList<>();


	public static void main(String[] args)
    {
		SwingUtilities.invokeLater(() -> { new RandomNumbers().mostrar(); });
    }

	public void apostar()
	{
		if(t1.getText().trim().equals("") || t2.getText().trim().equals(""))
		{
			limpar();
			JOptionPane.showMessageDialog(null,
						 "Os números são necessários para o processamento",
										"Atenção", JOptionPane.WARNING_MESSAGE);
		} 
		else if(Integer.parseInt(t2.getText().trim()) > Integer.parseInt(t1.getText().trim()))
		{
			JOptionPane.showMessageDialog(null, 
						 "A quantidade de números não pode ser maior que o limite",
										"Atenção", JOptionPane.WARNING_MESSAGE);
		} 
		else	
		{					
			limit = Integer.parseInt(t1.getText());
			number = Integer.parseInt(t2.getText());			
			StringBuilder s = new StringBuilder();

			numbers.add(r.nextInt(limit));
			for(int i = 1; i < number; i++)
			{
				numbers.add(1 + r.nextInt(limit));
				// Isso garante que os elementos não vão repetir
				if(numbers.get(i) == numbers.get(i - 1))	
				{
					numbers.set(i, 1 + r.nextInt(limit));
				}
			}
			Collections.sort(numbers);
			
			for(Integer num : numbers)
			{	
				if(num < 10) 
				{
					s.append("0"); s.append(num);
				}
				else 
				{	
					s.append(num);
				}
				s.append("  ");
			}								
			// A lista precisa ser limpa para receber a próxima aposta
			numbers.clear();

			if(a1.getText().equals(""))	
			{
				a1.setText(s.toString());	
			}
			else	
			{
				a1.setText(a1.getText() + "\n" + s.toString());	
			}
		}
	}

    public void mostrar()
    { 
		JFrame f1 = new JFrame("Números Aleatórios");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = d.width, y = d.height;
		a1 = new JTextArea(); a1.setText(""); a1.setEditable(false);
		JScrollPane p1 = new JScrollPane(a1);
		JLabel l1 = new JLabel("Escolha o limite: ");
		t1 = new JTextField();
		JLabel l2 = new JLabel("Quantos números na sequência?");
		t2 = new JTextField();
		JButton b1 = new JButton("Mostrar");
		JButton b2 = new JButton("Limpar");
		JPanel p2 = new JPanel(new GridLayout(3,2));
		p2.setMaximumSize(new Dimension(1920,50));
		p2.add(l1); p2.add(t1);
		p2.add(l2); p2.add(t2);
		p2.add(b1); p2.add(b2);
		Container c1 = f1.getContentPane();
		c1.setLayout(new BoxLayout(c1,BoxLayout.Y_AXIS));
		f1.add(p1); f1.add(p2);
		f1.setPreferredSize(new Dimension(x/2, y/2));
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLocation((x/2 - x/4),(y/2 - y/4));
		f1.pack();
		f1.setVisible(true);

		b1.addActionListener((ActionEvent e) ->	{ apostar(); });
		b2.addActionListener((ActionEvent e) -> { limpar(); });
    }


	public void limpar()
	{
		a1.setText(""); t1.setText(""); t2.setText("");
	}


 	public Graphics2D lotoFacil(Graphics g, Color cor, List<Integer> aposta)		//Volante da Lotofácil
  	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(0.8, 0.8);
		g2d.translate(pf.getImageableX(), pf.getImageableY() + 0);	// 1º Banco de Dezenas
		g2d.setColor(cor);

		// Falta mapear cada número para imprimir a aposta no volante
		for(int i = 0; i <= 14;i++)
  	 	{
			if(aposta.get(i) == 21) g2d.fillRect( 20, 20, 20, 15);	//21
			if(aposta.get(i) == 16) g2d.fillRect( 65, 20, 20, 15);	//16
			if(aposta.get(i) == 11) g2d.fillRect(110, 20, 20, 15);	//11
			if(aposta.get(i) ==  6) g2d.fillRect(155, 20, 20, 15);	//06
			if(aposta.get(i) ==  1) g2d.fillRect(200, 20, 20, 15);	//01

			if(aposta.get(i) == 22) g2d.fillRect( 20, 40, 20, 15);	//22
			if(aposta.get(i) == 17) g2d.fillRect( 65, 40, 20, 15);	//17
			if(aposta.get(i) == 12) g2d.fillRect(110, 40, 20, 15);	//12
			if(aposta.get(i) ==  7) g2d.fillRect(155, 40, 20, 15);	//07
			if(aposta.get(i) ==  2) g2d.fillRect(200, 40, 20, 15);	//02

			if(aposta.get(i) == 23) g2d.fillRect( 20, 60, 20, 15);	//23
			if(aposta.get(i) == 18) g2d.fillRect( 65, 60, 20, 15);	//18
			if(aposta.get(i) == 13) g2d.fillRect(110, 60, 20, 15);	//13
			if(aposta.get(i) ==  8) g2d.fillRect(155, 60, 20, 15);	//08
			if(aposta.get(i) ==  3) g2d.fillRect(200, 60, 20, 15);	//03

			if(aposta.get(i) == 24) g2d.fillRect( 20, 80, 20, 15);	//24
			if(aposta.get(i) == 19) g2d.fillRect( 65, 80, 20, 15);	//19
			if(aposta.get(i) == 14) g2d.fillRect(110, 80, 20, 15);	//14
			if(aposta.get(i) ==  9) g2d.fillRect(155, 80, 20, 15);	//09
			if(aposta.get(i) ==  4) g2d.fillRect(200, 80, 20, 15);	//04

			if(aposta.get(i) == 25) g2d.fillRect( 20,100, 20, 15);	//25
			if(aposta.get(i) == 20) g2d.fillRect( 65,100, 20, 15);	//20
			if(aposta.get(i) == 15) g2d.fillRect(110,100, 20, 15);	//15
			if(aposta.get(i) == 10) g2d.fillRect(155,100, 20, 15);	//10
			if(aposta.get(i) ==  5) g2d.fillRect(200,100, 20, 15);	//05
  	 	}
  	 	return g2d;
	}
}