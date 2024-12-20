package com.codekooking.licenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.codekooking.licenses.model.License;
import com.codekooking.licenses.services.LicenseService;
import com.codekooking.licenses.config.ServiceConfig;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
    @Autowired
    private LicenseService licenseService;

    @Autowired
    private ServiceConfig serviceConfig;

    /*
     * Get License list by Organization ID
     * */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
        return licenseService.getLicensesByOrg(organizationId);
    }

    /*
     * Get License by ID
     * */
    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return licenseService.getLicense(organizationId, licenseId);
    }

    /*
     * Create License
     * */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveLicenses(@RequestBody License license) {
        licenseService.saveLicense(license);
    }

    /*
     * Update License
     * */
    @RequestMapping(value = "/{licenseId}", method = RequestMethod.PUT)
    public String updateLicenses(@PathVariable("licenseId") String licenseId) {
        return String.format("This is PUT method");
    }

    /*
     * Delete License by ID
     * */
    @RequestMapping(value = "/{licenseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLicenses(@PathVariable("licenseId") String licenseId) {
        licenseService.deleteLicense(licenseId);
    }
}