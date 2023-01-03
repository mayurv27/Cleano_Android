package com.example.cleanofinal;

public class fetch {
    String Tshirt,Saree,Pant,Blazer,Blanket,Bedsheet;


    public fetch(){}

    public fetch(String tshirt, String saree, String pant, String blazer, String blanket, String bedsheet) {
        Tshirt = tshirt;
        Saree = saree;
        Pant = pant;
        Blazer = blazer;
        Blanket = blanket;
        Bedsheet = bedsheet;
    }

    public String getTshirt() {
        return Tshirt;
    }

    public void setTshirt(String tshirt) {
        Tshirt = tshirt;
    }

    public String getSaree() {
        return Saree;
    }

    public void setSaree(String saree) {
        Saree = saree;
    }

    public String getPant() {
        return Pant;
    }

    public void setPant(String pant) {
        Pant = pant;
    }

    public String getBlazer() {
        return Blazer;
    }

    public void setBlazer(String blazer) {
        Blazer = blazer;
    }

    public String getBlanket() {
        return Blanket;
    }

    public void setBlanket(String blanket) {
        Blanket = blanket;
    }

    public String getBedsheet() {
        return Bedsheet;
    }

    public void setBedsheet(String bedsheet) {
        Bedsheet = bedsheet;
    }
}
