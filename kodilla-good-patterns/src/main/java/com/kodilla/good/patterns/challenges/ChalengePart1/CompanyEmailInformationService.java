package com.kodilla.good.patterns.challenges.ChalengePart1;

public class CompanyEmailInformationService implements InformationCompanyService {
   @Override
    public void informCompany(Company company) {
        System.out.println("Sending email to " + company.getCompanyEmail());
    }
}
