/*
 *			Código JAVA para gerar um vetor de números aleatórios em ordem crescente
 *			de acordo com os critérios a ser definidos pelo usuário
 */


import java.awt.*;
import java.awt.event.*;
//import java.awt.geom.*;
//import java.awt.image.BufferedImage;
import java.awt.print.*;

//import java.lang.Thread;

import javax.swing.*;

//import java.util.Arrays;
import java.util.Random;


public class RandomNumbers
{	private JTextField t1, t2;
	private JTextArea a1 = null;
	public Random r = new Random();
	public PageFormat pf = null;

	static int acc[];
	static int aposta[][];


	public int[] ordenaVetor(int[] array)
	{int aux = 0;
	   for(int j = 0; j < array.length; j++)
	   {
			for(int i = 1; i < array.length; i++)
			{
				if(array[i] < array[i - 1])
				{
					aux = array[i - 1];
					array[i - 1] = array[i];
					array[i] = aux;
				}
				else if(array[i] == array[i - 1])
				{
					do
					{	
						array[i] = 1 + r.nextInt(Integer.parseInt(t1.getText()));
					}while(array[i] == array[i - 1]);
				ordenaVetor(array);
				}
			}
	   }
	 return array;
	}


    public static void main(String[] args)
    {
		SwingUtilities.invokeLater(new Runnable()
    	{	public void run()
    		{
				new RandomNumbers().mostrar();
    		}
    	});
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


		b1.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e)
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
					acc = new int[Integer.parseInt(t2.getText())];
					//int x = 0;
					StringBuilder s = new StringBuilder();


					acc[0] = 1 + r.nextInt(Integer.parseInt(t1.getText()));

					for(int i = 1; i < Integer.parseInt(t2.getText()); i++)
					{
						acc[i] = 1 + r.nextInt(Integer.parseInt(t1.getText()));
						if(acc[i] == acc[i - 1])
						{
							acc[i] = 1 + r.nextInt(Integer.parseInt(t1.getText()));

						}
					}
					ordenaVetor(acc);


					for(int i = 0; i < Integer.parseInt(t2.getText()); i++)
					{	if(acc[i] < 10) 
						{
							s.append("0"); s.append(acc[i]);
						}
						else 
						{	
							s.append(acc[i]);
						}
						if(i < Integer.parseInt(t2.getText())-1) 
						{
							s.append(" - ");
						}
					}

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
		});


		b2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
				{
					limpar();
				}
		});


    }

	public void limpar()
	{
		a1.setText(""); t1.setText(""); t2.setText("");
	}

 	public Graphics2D lotoFacil(Graphics g, Color cor, int array[])		//Volante da Lotofácil
  	{Graphics2D g2d = (Graphics2D) g;
 	 g2d.scale(0.8, 0.8);
  	 g2d.translate
  	 (pf.getImageableX(), pf.getImageableY() + 0);	// 1º Banco de Dezenas
  	 g2d.setColor(cor);

	 // Falta mapear cada número para imprimir a aposta no volante
  	 for(int i = 0; i <= 14;i++)
  	 	{
			if(array[i] == 21) g2d.fillRect( 20, 20, 20, 15);	//21
			if(array[i] == 16) g2d.fillRect( 65, 20, 20, 15);	//16
			if(array[i] == 11) g2d.fillRect(110, 20, 20, 15);	//11
			if(array[i] ==  6) g2d.fillRect(155, 20, 20, 15);	//06
			if(array[i] ==  1) g2d.fillRect(200, 20, 20, 15);	//01

			if(array[i] == 22) g2d.fillRect( 20, 40, 20, 15);	//22
			if(array[i] == 17) g2d.fillRect( 65, 40, 20, 15);	//17
			if(array[i] == 12) g2d.fillRect(110, 40, 20, 15);	//12
			if(array[i] ==  7) g2d.fillRect(155, 40, 20, 15);	//07
			if(array[i] ==  2) g2d.fillRect(200, 40, 20, 15);	//02

			if(array[i] == 23) g2d.fillRect( 20, 60, 20, 15);	//23
			if(array[i] == 18) g2d.fillRect( 65, 60, 20, 15);	//18
			if(array[i] == 13) g2d.fillRect(110, 60, 20, 15);	//13
			if(array[i] ==  8) g2d.fillRect(155, 60, 20, 15);	//08
			if(array[i] ==  3) g2d.fillRect(200, 60, 20, 15);	//03

			if(array[i] == 24) g2d.fillRect( 20, 80, 20, 15);	//24
			if(array[i] == 19) g2d.fillRect( 65, 80, 20, 15);	//19
			if(array[i] == 14) g2d.fillRect(110, 80, 20, 15);	//14
			if(array[i] ==  9) g2d.fillRect(155, 80, 20, 15);	//09
			if(array[i] ==  4) g2d.fillRect(200, 80, 20, 15);	//04

			if(array[i] == 25) g2d.fillRect( 20,100, 20, 15);	//25
			if(array[i] == 20) g2d.fillRect( 65,100, 20, 15);	//20
			if(array[i] == 15) g2d.fillRect(110,100, 20, 15);	//15
			if(array[i] == 10) g2d.fillRect(155,100, 20, 15);	//10
			if(array[i] ==  5) g2d.fillRect(200,100, 20, 15);	//05
  	 	}
  	 return g2d;
	}
}
