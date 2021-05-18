/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.05.2021
 * @author 
 */

public class Roller {
  
  // Anfang Attribute
  private double tankgroesse;
  private double tankinhalt;
  private int kilometerstand;
  // Ende Attribute
  
  public Roller(double pTankgroesse, int pKmStand, double pTankinhalt) {
    tankgroesse = pTankgroesse;
    tankinhalt = pTankinhalt;
    kilometerstand = pKmStand;
  }

  // Anfang Methoden

  public double getTankgroesse() {
    return tankgroesse;
  }

  public double getTankinhalt() {
    return tankinhalt;
  }

  public int getKilometerstand() {
    return kilometerstand;
  }
  
  public void tanke(double pMenge) 
  {
    if(passtInTank(pMenge))
    {
      tankinhalt = tankinhalt + pMenge;
    }  
  }
  
  public void fahre(int pStrecke)
  {
    double spritverbrauch = 0.03 * pStrecke;
    if(spritverbrauch <= tankinhalt)
    {
      kilometerstand = kilometerstand + pStrecke;
      tankinhalt = tankinhalt - spritverbrauch;
    }
  }
  
  public boolean passtInTank(double pMenge)
  {
    if(tankgroesse >= tankinhalt + pMenge)
    {
      return true;
    }
    else 
    {
      return false;  
    }
  }

  // Ende Methoden
} // end of roller

