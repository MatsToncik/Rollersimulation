/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.05.2021
 * @author 
 */

public class Besitzer {
  
  // Anfang Attribute
  private double geld;
  private String name;
  private Roller meinRoller;
  // Ende Attribute
  
  public Besitzer(String pName, double pGeld, Roller pRoller) 
  {
    geld = pGeld;
    name = pName;
    meinRoller = pRoller;
  }

  // Anfang Methoden
  public String getName() {
    return name;
  }

  public double getGeld() {
    return geld;
  }

  public Roller getMeinRoller() {
    return meinRoller;
  }
  
  public void tankeDeinenRoller(double pMenge) 
  {
    if ((pMenge * 1.5) <= geld) 
    {
      meinRoller.tanke(pMenge);
      geld = geld - (pMenge * 1.5); 
    } 
  }
      
  public void fahreDeinenRoller(int pStrecke) 
  {
      meinRoller.fahre(pStrecke);  
  }
      
  public void erhalteTaschengeld(double pSumme)
  {
      geld = geld + pSumme;    
  }    
  // Ende Methoden
} // end of besitzer

