package org.alexweb.tax.controllers;

import org.alexweb.tax.entities.TaxDeclarationEntity;
import org.alexweb.tax.services.TaxDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxCalculatorController {
    private final TaxDataService taxDataService;

    @Autowired
    public TaxCalculatorController(TaxDataService taxDataService) {
        this.taxDataService = taxDataService;
    }

    @PostMapping("/updateTaxData")
    public ResponseEntity<String> updateTaxData() {
        return ResponseEntity.ok("All Good");
    }

    @PostMapping("/calculateTaxData")
    public ResponseEntity<TaxDeclarationEntity> calculateTaxData() {
        return ResponseEntity.ok(new TaxDeclarationEntity());
    }

    @PostMapping("/generateTaxDeclaration")
    public ResponseEntity<Resource> generateTaxDeclaration() {
        return ResponseEntity.ok(null);
    }
}
