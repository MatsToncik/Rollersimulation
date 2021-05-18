import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 18.05.2021
 * @author Mats Toncik 
 */


public class rollersimulation extends JFrame {
  
  // Anfang Attribute
  private JLabel jLabelGeldErstellen = new JLabel();
  private JLabel jLabelNameErstellen = new JLabel();
  private JLabel jLabelTankinhaltErstellen = new JLabel();
  private JLabel jLabelTankgroesseErstellen = new JLabel();
  private JLabel jLabelKilometerstandErstellen = new JLabel();
  private JLabel jLabelKilometerstandDisplay = new JLabel();
  private JLabel jLabelTankgroesseDisplay = new JLabel();
  private JLabel jLabelTankinhaltDisplay = new JLabel();
  private JLabel jLabelNameDisplay = new JLabel();
  private JLabel jLabelGeldDisplay = new JLabel();
  private JButton jButtonErstellen = new JButton();
  private JButton jButtonTanken = new JButton();
  private JButton jButtonFahren = new JButton();
  private JButton jButtonTaschengeld = new JButton();
  private JTextField jTextFieldName = new JTextField();
  private JNumberField jNumberFieldGeld = new JNumberField();
  private JNumberField jNumberFieldTankgroesse = new JNumberField();
  private JNumberField jNumberFieldKilometerstand = new JNumberField();
  private JNumberField jNumberFieldTankinhalt = new JNumberField();
  private JNumberField jNumberFieldTaschengeld = new JNumberField();
  private JNumberField jNumberFieldFahren = new JNumberField();
  private JNumberField jNumberFieldTanken = new JNumberField();
  
  double tankinhalt;
  double tankgroesse;
  int kilometerstand;
  double geld;
  String name;
  // Ende Attribute
  
  public rollersimulation() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 457; 
    int frameHeight = 250;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Roller und Besitzer erstellen | RSimulation");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    //Buttons
    jButtonErstellen.setBounds(32, 152, 200, 25);
    jButtonErstellen.setText("Besitzer und Roller erstellen");
    jButtonErstellen.setMargin(new Insets(2, 2, 2, 2));
    jButtonErstellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonErstellen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonErstellen);
    jButtonTanken.setBounds(440, 32, 145, 25);
    jButtonTanken.setText("Roller tanken");
    jButtonTanken.setMargin(new Insets(2, 2, 2, 2));
    jButtonTanken.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonTanken_ActionPerformed(evt);
      }
    });
    cp.add(jButtonTanken);
    jButtonFahren.setBounds(440, 64, 145, 25);
    jButtonFahren.setText("Roller fahren");
    jButtonFahren.setMargin(new Insets(2, 2, 2, 2));
    jButtonFahren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonFahren_ActionPerformed(evt);
      }
    });
    cp.add(jButtonFahren);
    jButtonTaschengeld.setBounds(440, 96, 145, 25);
    jButtonTaschengeld.setText("Taschengeld erhalten");
    jButtonTaschengeld.setMargin(new Insets(2, 2, 2, 2));
    jButtonTaschengeld.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonTaschengeld_ActionPerformed(evt);
      }
    });
    cp.add(jButtonTaschengeld);
    //
    //Fields
    jTextFieldName.setBounds(88, 32, 105, 25);
    cp.add(jTextFieldName);
    jNumberFieldGeld.setBounds(88, 64, 105, 25);
    jNumberFieldGeld.setText("");
    cp.add(jNumberFieldGeld);
    jNumberFieldTankgroesse.setBounds(320, 64, 105, 25);
    jNumberFieldTankgroesse.setText("");
    cp.add(jNumberFieldTankgroesse);
    jNumberFieldKilometerstand.setBounds(320, 96, 105, 25);
    jNumberFieldKilometerstand.setText("");
    cp.add(jNumberFieldKilometerstand);
    jNumberFieldTankinhalt.setBounds(320, 32, 105, 25);
    jNumberFieldTankinhalt.setText("");
    cp.add(jNumberFieldTankinhalt);
    jNumberFieldTaschengeld.setBounds(600, 96, 145, 25);
    jNumberFieldTaschengeld.setText("Euro");
    cp.add(jNumberFieldTaschengeld);
    jNumberFieldFahren.setBounds(600, 64, 145, 25);
    jNumberFieldFahren.setText("Strecke");
    cp.add(jNumberFieldFahren);
    jNumberFieldTanken.setBounds(600, 32, 145, 25);
    jNumberFieldTanken.setText("Liter");
    cp.add(jNumberFieldTanken);
    //
    //Erstellen Text
    jLabelGeldErstellen.setBounds(32, 64, 65, 25);
    jLabelGeldErstellen.setText("Geld");
    cp.add(jLabelGeldErstellen);
    jLabelNameErstellen.setBounds(32, 32, 65, 25);
    jLabelNameErstellen.setText("Name");
    cp.add(jLabelNameErstellen);
    jLabelTankinhaltErstellen.setBounds(220, 32, 110, 25);
    jLabelTankinhaltErstellen.setText("Tankinhalt");
    cp.add(jLabelTankinhaltErstellen);
    jLabelTankgroesseErstellen.setBounds(220, 64, 110, 25);
    jLabelTankgroesseErstellen.setText("Tankgroesse");
    cp.add(jLabelTankgroesseErstellen);
    jLabelKilometerstandErstellen.setBounds(220, 96, 110, 25);
    jLabelKilometerstandErstellen.setText("Kilometerstand");
    cp.add(jLabelKilometerstandErstellen);
    //
    //Display
    jLabelKilometerstandDisplay.setBounds(32, 200, 200, 25);
    jLabelKilometerstandDisplay.setText("Kilometerstand: ? km");
    cp.add(jLabelKilometerstandDisplay);
    jLabelTankgroesseDisplay.setBounds(32, 232, 200, 25);
    jLabelTankgroesseDisplay.setText("Tankgroesse: ? l");
    cp.add(jLabelTankgroesseDisplay);
    jLabelTankinhaltDisplay.setBounds(32, 264, 200, 25);
    jLabelTankinhaltDisplay.setText("Tankinhalt: ? l");
    cp.add(jLabelTankinhaltDisplay);
    jLabelNameDisplay.setBounds(32, 296, 200, 25);
    jLabelNameDisplay.setText("Name: ?");
    cp.add(jLabelNameDisplay);
    jLabelGeldDisplay.setBounds(32, 328, 200, 25);
    jLabelGeldDisplay.setText("Geld: ? €");
    cp.add(jLabelGeldDisplay);
    //
    jButtonTanken.setVisible(false);
    jButtonFahren.setVisible(false);
    jButtonTaschengeld.setVisible(false);
    jNumberFieldTanken.setVisible(false);
    jNumberFieldFahren.setVisible(false);
    jNumberFieldTaschengeld.setVisible(false);
    jLabelKilometerstandDisplay.setVisible(false);
    jLabelTankgroesseDisplay.setVisible(false);
    jLabelTankinhaltDisplay.setVisible(false);
    jLabelNameDisplay.setVisible(false);
    jLabelGeldDisplay.setVisible(false);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public rollersimulation
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new rollersimulation();
  } // end of main
  
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  } 
  
  public void jButtonTanken_ActionPerformed(ActionEvent evt) {
    double pTankgroesse = tankgroesse;
    double pTankinhalt = tankinhalt;
    int pKmStand = kilometerstand;
    String pName = name;
    double pGeld = geld;
    Roller pRoller = new Roller(pTankgroesse, pKmStand, pTankinhalt);
    Roller meinRoller = pRoller;
    Besitzer meinBesitzer = new Besitzer(pName, pGeld, pRoller);
    double pMenge = jNumberFieldTanken.getDouble();
    meinBesitzer.tankeDeinenRoller(pMenge);
    double displayTankinhalt = meinRoller.getTankinhalt();
    Double displayTankinhaltDouble = new Double(round(displayTankinhalt, 2));
    jLabelTankinhaltDisplay.setText("Tankinhalt: " + displayTankinhaltDouble.toString() + "l");
    double displayGeld = meinBesitzer.getGeld();
    Double displayGeldDouble = new Double(round(displayGeld, 2));
    jLabelGeldDisplay.setText("Geld: " + displayGeldDouble.toString() + "€");
    tankinhalt = meinRoller.getTankinhalt();
    geld = meinBesitzer.getGeld();
            
  } // end of jButtonTanken_ActionPerformed
  
  public void jButtonFahren_ActionPerformed(ActionEvent evt) {
    double pTankgroesse = tankgroesse;
    double pTankinhalt = tankinhalt;
    int pKmStand = kilometerstand;
    String pName = name;
    double pGeld = geld;
    Roller pRoller = new Roller(pTankgroesse, pKmStand, pTankinhalt);
    Roller meinRoller = pRoller;
    Besitzer meinBesitzer = new Besitzer(pName, pGeld, pRoller);
    int pStrecke = jNumberFieldFahren.getInt();
    meinBesitzer.fahreDeinenRoller(pStrecke);
    double displayTankinhalt = meinRoller.getTankinhalt();
    Double displayTankinhaltDouble = new Double(round(displayTankinhalt, 2));
    jLabelTankinhaltDisplay.setText("Tankinhalt: " + displayTankinhaltDouble.toString() + "l");
    int displayKilometerstand = meinRoller.getKilometerstand();
    Integer displayKilometerstandInteger = new Integer(displayKilometerstand);
    jLabelKilometerstandDisplay.setText("Kilometerstand: " + displayKilometerstandInteger.toString() + "km");
    tankinhalt = meinRoller.getTankinhalt();
    kilometerstand = meinRoller.getKilometerstand();
    
      
  } // end of jButton5_ActionPerformed
  
  public void jButtonErstellen_ActionPerformed(ActionEvent evt) {
    double pTankgroesse = jNumberFieldTankgroesse.getDouble();
    double pTankinhalt = jNumberFieldTankinhalt.getDouble();
    int pKmStand = jNumberFieldKilometerstand.getInt();
    String pName = jTextFieldName.getText();
    double pGeld = jNumberFieldGeld.getDouble();
    Roller pRoller = new Roller(pTankgroesse, pKmStand, pTankinhalt);
    Roller meinRoller = pRoller;
    Besitzer meinBesitzer = new Besitzer(pName, pGeld, pRoller);
    int displayKilometerstand = meinRoller.getKilometerstand();
    Integer displayKilometerstandInteger = new Integer(displayKilometerstand);
    double displayTankgroesse = meinRoller.getTankgroesse();
    Double displayTankgroesseDouble = new Double(round(displayTankgroesse, 2));
    double displayTankinhalt = meinRoller.getTankinhalt();
    Double displayTankinhaltDouble = new Double(round(displayTankinhalt, 2));
    double displayGeld = meinBesitzer.getGeld();
    Double displayGeldDouble = new Double(round(displayGeld, 2));
    jLabelKilometerstandDisplay.setText("Kilometerstand: " + displayKilometerstandInteger.toString() + "km");
    jLabelTankgroesseDisplay.setText("Tankgroesse: " + displayTankgroesseDouble.toString() + "l");
    jLabelTankinhaltDisplay.setText("Tankinhalt: " + displayTankinhaltDouble.toString() + "l");
    jLabelNameDisplay.setText("Name: " + pName);
    jLabelGeldDisplay.setText("Geld: " + displayGeldDouble.toString() + "€");
    tankinhalt = pTankinhalt;
    tankgroesse = pTankgroesse;
    kilometerstand = pKmStand;
    name = pName;
    geld = pGeld;
    

    jLabelGeldErstellen.setVisible(false);
    jLabelNameErstellen.setVisible(false);
    jLabelTankinhaltErstellen.setVisible(false);
    jLabelTankgroesseErstellen.setVisible(false);
    jLabelKilometerstandErstellen.setVisible(false);
    jTextFieldName.setVisible(false);
    jNumberFieldGeld.setVisible(false);
    jNumberFieldTankgroesse.setVisible(false);
    jNumberFieldKilometerstand.setVisible(false);
    jNumberFieldTankinhalt.setVisible(false);
    jButtonErstellen.setVisible(false);
    jButtonTanken.setVisible(true);
    jButtonFahren.setVisible(true);
    jButtonTaschengeld.setVisible(true);
    jNumberFieldTanken.setVisible(true);
    jNumberFieldFahren.setVisible(true);
    jNumberFieldTaschengeld.setVisible(true);
    jLabelKilometerstandDisplay.setVisible(true);
    jLabelTankgroesseDisplay.setVisible(true);
    jLabelTankinhaltDisplay.setVisible(true);
    jLabelNameDisplay.setVisible(true);
    jLabelGeldDisplay.setVisible(true);
    
    jButtonFahren.setBounds(32, 64, 145, 25);
    jButtonTanken.setBounds(32, 32, 145, 25);
    jButtonTaschengeld.setBounds(32, 96, 145, 25);
    jNumberFieldTanken.setBounds(209, 32, 145, 25);
    jNumberFieldFahren.setBounds(209, 64, 145, 25);
    jNumberFieldTaschengeld.setBounds(209, 96, 145, 25);
    
    jLabelKilometerstandDisplay.setBounds(32, 160, 200, 25);
    jLabelTankgroesseDisplay.setBounds(32, 192, 200, 25);
    jLabelTankinhaltDisplay.setBounds(32, 224, 200, 25);
    jLabelNameDisplay.setBounds(209, 160, 200, 25);
    jLabelGeldDisplay.setBounds(209, 192, 200, 25);
    setTitle("Simuliere was du willst... | RSimulation");
    setSize(new Dimension(400,400));
  } // end of jButtonErstellen_ActionPerformed

  public void jButtonTaschengeld_ActionPerformed(ActionEvent evt) {
    
    double pTankgroesse = tankgroesse;
    double pTankinhalt = tankinhalt;
    int pKmStand = kilometerstand;
    String pName = name;
    double pGeld = geld;
    Roller pRoller = new Roller(pTankgroesse, pKmStand, pTankinhalt);
    Besitzer meinBesitzer = new Besitzer(pName, pGeld, pRoller);
    double pSumme = jNumberFieldTaschengeld.getDouble();
    meinBesitzer.erhalteTaschengeld(pSumme);
    double displayGeld = meinBesitzer.getGeld();
    Double displayGeldDouble = new Double(round(displayGeld, 2));
    jLabelGeldDisplay.setText("Geld: " + displayGeldDouble.toString() + "€");
    geld = meinBesitzer.getGeld();  
  } // end of jButton6_ActionPerformed
    
  // Ende Methoden
} // end of class rollersimulation

