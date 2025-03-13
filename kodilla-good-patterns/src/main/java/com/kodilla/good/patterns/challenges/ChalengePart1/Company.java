package com.kodilla.good.patterns.challenges.ChalengePart1;

public class Company {
    private final String companyName;
    private final String companyAddress;
    private final String companyEmail;

    public Company(String comapnyName, String companyAddress, String companyEmail) {
        this.companyName = comapnyName;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }
}
