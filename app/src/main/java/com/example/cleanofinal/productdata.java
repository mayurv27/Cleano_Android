package com.example.cleanofinal;

public class productdata {
    private String Bedsheet;
    private String Blanket;
    private String Blazer;
    private String Pant;
    private String Saree;
    private String Tshirt;

    private productdata(){}


    private productdata(String Bedsheet,String Blanket,String Blazer,String Pant,String Saree,String Tshirt){
    this.Bedsheet=Bedsheet;
        this.Blanket=Blanket;
        this.Blazer=Blazer;
        this.Pant=Pant;
        this.Saree=Saree;
        this.Tshirt=Tshirt;






    }


    public String getBedsheet() {
        return Bedsheet;
    }

    public void setBedsheet(String bedsheet) {
        Bedsheet = bedsheet;
    }

    public String getBlanket() {
        return Blanket;
    }

    public void setBlanket(String blanket) {
        Blanket = blanket;
    }

    public String getBlazer() {
        return Blazer;
    }

    public void setBlazer(String blazer) {
        Blazer = blazer;
    }

    public String getPant() {
        return Pant;
    }

    public void setPant(String pant) {
        Pant = pant;
    }

    public String getSaree() {
        return Saree;
    }

    public void setSaree(String saree) {
        Saree = saree;
    }

    public String getTshirt() {
        return Tshirt;
    }

    public void setTshirt(String tshirt) {
        Tshirt = tshirt;
    }
}
