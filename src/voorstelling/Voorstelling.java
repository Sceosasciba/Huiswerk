/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voorstelling;


/**
 *
 * @author Stan
 */
public class Voorstelling {

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public void setAantalVerkocht(int aantalVerkocht) {
        this.aantalVerkocht = aantalVerkocht;
    }

    private String naam;
    private int aantalPlaatsen;
    private int aantalVerkocht;
    private int aantalTotaal;
    

    public Voorstelling(String naam, int aantal) {
        this.naam = naam;
        this.aantalPlaatsen = aantal;
        this.aantalVerkocht = 0;
        this.aantalTotaal = aantal;
    }

    public void verkoopKaartje() {
        if (aantalPlaatsen > 0) {
            aantalPlaatsen--;
            aantalVerkocht++;
        }
    }
    
    public void verkoopKaartje(int aantal){
        if (aantalPlaatsen > 0 && aantalPlaatsen - aantal >= 0) {
            setAantalPlaatsen(aantalPlaatsen - aantal);
            setAantalVerkocht(aantalVerkocht + aantal);
        }
    }
    
    public void annuleerKaartje(){
        if (aantalPlaatsen < aantalTotaal) {
            aantalPlaatsen++;
            aantalVerkocht--;
        }
    }
    
    public void annuleerKaartje(int aantal){
        if (aantalPlaatsen < aantalTotaal && aantal + aantalPlaatsen <= aantalTotaal) {
            setAantalPlaatsen(aantalPlaatsen + aantal);
            setAantalVerkocht(aantalVerkocht - aantal);
        }
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public int getAantalVerkocht() {
        return aantalVerkocht;
    }
    
    
    
    
}
