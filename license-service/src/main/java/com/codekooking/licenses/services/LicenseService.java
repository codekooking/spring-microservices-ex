package com.codekooking.licenses.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.codekooking.licenses.model.License;

@Service
public class LicenseService {

    public License getLicense(String licenseId){
        return new License()
                .withId(licenseId)
                .withOrganizationId( UUID.randomUUID().toString() )
                .withProductName("Simple Exchange Project")
                .withLicenseType("Forever");
    }

    public void saveLicense(License license){

    }

    public void updateLicense(License license){

    }

    public void deleteLicense(License license){

    }

}
