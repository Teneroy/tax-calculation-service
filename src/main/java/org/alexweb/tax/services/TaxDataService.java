package org.alexweb.tax.services;

import org.alexweb.tax.dao.TaxDataRepository;
import org.alexweb.tax.entities.TaxDeclarationEntity;
import org.alexweb.tax.utils.TaxInfoConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxDataService {
    private final TaxDataRepository repository;

    @Autowired
    public TaxDataService(TaxDataRepository repository) {
        this.repository = repository;
    }

    public TaxDeclarationEntity getTaxDeclarationByTaxId(String taxId) {
        if((taxId.length() != TaxInfoConstants.TAX_ID_SIZE) || !taxId.matches("^[0-9]*$"))
            throw new TaxIdFormatException();
        return repository.findByTaxId(taxId);
    }

    static class TaxIdFormatException extends IllegalArgumentException {
        TaxIdFormatException() {
            super("You are trying to pass invalid tax identification number!");
        }
    }
}
