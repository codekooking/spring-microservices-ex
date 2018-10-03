package com.codekooking.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.codekooking.organization.model.Organization;
import com.codekooking.organization.services.OrganizationService;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {

    @Autowired
    private OrganizationService orgService;

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
        return orgService.getOrg(organizationId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateOrganization(@RequestBody Organization org) {
        orgService.updateOrg(org);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveOrganization(@RequestBody Organization org) {
        orgService.saveOrg(org);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@RequestBody Organization org) {
        orgService.deleteOrg(org);
    }
}
