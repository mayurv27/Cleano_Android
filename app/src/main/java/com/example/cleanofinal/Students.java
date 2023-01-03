package com.example.cleanofinal;

public class Students {

    String Tshirt;
    String Blazer;
    String Saree;
    String Pant;
    String Blanket;
    String Bedsheet;
    String Total;
    String Total_Estimate;

    public Students(String tshirt, String blazer, String saree, String pant, String blanket, String bedsheet, String total, String total_Estimate) {
        Tshirt = tshirt;
        Blazer = blazer;
        Saree = saree;
        Pant = pant;
        Blanket = blanket;
        Bedsheet = bedsheet;
        Total = total;
        Total_Estimate = total_Estimate;
    }

    public String getTshirt() {
        return Tshirt;
    }

    public String getBlazer() {
        return Blazer;
    }

    public String getSaree() {
        return Saree;
    }

    public String getPant() {
        return Pant;
    }

    public String getBlanket() {
        return Blanket;
    }

    public String getBedsheet() {
        return Bedsheet;
    }

    public String getTotal() {
        return Total;
    }

    public String getTotal_Estimate() {
        return Total_Estimate;
    }
}
