package projectnumericalmethods;

import java.awt.*;
import javax.swing .*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
public class Projectnumericalmethods extends JFrame{
    private JRadioButton relativo,absoluto;
    private JButton redondear,truncar,limpiar;
    private JLabel res,vreal,vaproxi,numcifr;
    private JTextField valorreal,valoraproximado,resultado,numcifras;
    JPanel este=new JPanel();
    JPanel oeste=new JPanel();
    private int errorelejido=0;
    private int numerodecifras=0;
    int divisor=1;
    
    private double tenervalorreal;

    public Projectnumericalmethods(){
        super("Proyecto Metodos numericos");
        
        res =new JLabel("Resultado obtenido");
        vreal =new JLabel("Valor real");
        vaproxi =new JLabel("Valor aproximado");
        valorreal=new JTextField(20);
        valoraproximado=new JTextField(20);
        resultado=new JTextField(20);
        relativo=new JRadioButton("Relativo");
        absoluto=new JRadioButton("absoluto");
        numcifr=new JLabel("Numero de cifras");
        numcifras=new JTextField(20);
        redondear=new JButton("Redondeo");
        truncar=new JButton("Truncar");
        limpiar=new JButton("Limpiar");
        
        manejareventos acciones=new manejareventos();
        
        este=new JPanel();
        este.setLayout(new GridLayout(8,1));
        este.add(vreal);
        este.add(valorreal);
        este.add(vaproxi);
        este.add(valoraproximado);
        absoorela.add(absoluto);
        absoorela.add(relativo);
        este.add(absoluto);
        este.add(relativo);
        este.add(numcifr);
        este.add(numcifras);
        
        JPanel resultado1=new JPanel();
        FlowLayout ordenar=new FlowLayout();
        resultado1.setLayout(ordenar);
        resultado1.add(res);
        resultado1.add(resultado);
        
        JPanel botones=new JPanel();
        FlowLayout orde=new FlowLayout();
        botones.setLayout(orde);
        botones.add(redondear);
        botones.add(truncar);
        botones.add(limpiar);
        redondear.addActionListener(acciones);
        truncar.addActionListener(acciones);
        limpiar.addActionListener(acciones);
        
        Container paneles=new Container();
        paneles=getContentPane();
        paneles.add(este,BorderLayout.WEST);
        paneles.add(resultado1,BorderLayout.CENTER);
        paneles.add(botones,BorderLayout.SOUTH);
    }
    
    ButtonGroup absoorela= new ButtonGroup();
    public static void main(String[] args) {
        
        Projectnumericalmethods aplicacion=new Projectnumericalmethods();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.setSize(475,250);
        aplicacion.setVisible(true);
    }
     private class manejareventos implements ActionListener{
        public void actionPerformed(ActionEvent accion){
        	if(accion.getSource()==redondear){
        		try{	
        			BigDecimal numero=new BigDecimal(Double.parseDouble(valorreal.getText()));
        			numero=numero.setScale(Integer.parseInt(numcifras.getText()),RoundingMode.HALF_UP);
        			
        			
        			if(errorelejido==1){
        				double devuelto=numero.doubleValue();
        				double resultadototal=funcionrelativo(devuelto);
        				valoraproximado.setText(String.valueOf(numero.doubleValue()));resultado.setText(String.valueOf(resultadototal));
        			}
        			else{
        				double devuelto=numero.doubleValue();
        				double resultadototal=funcionabsoluto(devuelto);
        				valoraproximado.setText(String.valueOf(numero.doubleValue()));resultado.setText(String.valueOf(resultadototal));
        			}
        		}catch(InputMismatchException e){
        			JOptionPane.showMessageDialog(null,"los datos deben ser numericos");
        		}catch(Exception e){
        			JOptionPane.showMessageDialog(null,"los campos estan vacios"+e);
        		}
        	}
        	//
        	if(accion.getSource()==truncar){
        		try{
        			//
        			double cambio1=Double.parseDouble(valorreal.getText());
        			double redondeo=cambio1%1;
        			int vueltas=Integer.parseInt(numcifras.getText());
        			
        			for(int n=0;n<vueltas;n++){
        				divisor*=10;
        			}
        			
        			double truncamiento=divisor*redondeo-((divisor*redondeo)%1);        			
        			cambio1=(cambio1-redondeo);
        			double negro=truncamiento/divisor;
        			double valortruncado=cambio1+negro;
        			
        			
        			if(errorelejido==1){
        				double resultadototal=funcionrelativo(valortruncado);
        				valoraproximado.setText(String.valueOf(valortruncado));resultado.setText(String.valueOf(resultadototal));
        			}	else{
        				double resultadototal=funcionabsoluto(valortruncado);
        				valoraproximado.setText(String.valueOf(valortruncado));resultado.setText(String.valueOf(resultadototal));
        			}
        		}catch(InputMismatchException e){
        			JOptionPane.showMessageDialog(null,"los datos deben ser numericos");
        		}catch(Exception e){
        			JOptionPane.showMessageDialog(null,"los campos estan vacios"+e);
        		}
        	}
        	if(relativo.isSelected()){
        		errorelejido=1;
        	}
        	if(absoluto.isSelected()){
        		errorelejido=2;
        	}
        	if(accion.getSource()==limpiar){
        		valoraproximado.setText("");
        		valorreal.setText("");
        		numcifras.setText("");
        		resultado.setText("");
        	}
        }   
    }
     double funcionrelativo(double absoluto){
    		tenervalorreal=Double.parseDouble(valorreal.getText());
    		double resultadof=tenervalorreal-absoluto;
    		return resultadof/tenervalorreal;
    		
		}
    	double funcionabsoluto(double resultado){
    		tenervalorreal=Double.parseDouble(valorreal.getText());
    		double resultadof=tenervalorreal-resultado;
    		return resultadof;
    	}
    
}
