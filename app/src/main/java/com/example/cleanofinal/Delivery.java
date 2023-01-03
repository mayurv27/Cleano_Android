package com.example.cleanofinal;

public class Delivery {


    String CustName;
    String CustEmail;
    String CustNumber;
    String CustAddress;
    String CustClothes;
    String CustCost;

    public Delivery(String custName, String custEmail, String custNumber, String custAddress, String custClothes, String custCost) {
        CustName = custName;
        CustEmail = custEmail;
        CustNumber = custNumber;
        CustAddress = custAddress;
        CustClothes = custClothes;
        CustCost = custCost;
    }

    public String getCustName() {
        return CustName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public String getCustNumber() {
        return CustNumber;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public String getCustClothes() {
        return CustClothes;
    }

    public String getCustCost() {
        return CustCost;
    }
}
