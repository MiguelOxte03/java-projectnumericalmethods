package projectnumericalmethods;

import java.awt.*;
import javax.swing .*;
import java.awt.event.*;
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
    }
    
    ButtonGroup absoorela= new ButtonGroup();
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
