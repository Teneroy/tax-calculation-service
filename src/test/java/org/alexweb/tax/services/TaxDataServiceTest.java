package org.alexweb.tax.services;

import org.alexweb.tax.dao.TaxDataRepository;
import org.alexweb.tax.entities.TaxDeclarationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@SpringBootTest
class TaxDataServiceTest {
    @Mock
    private TaxDataRepository repository;

    @InjectMocks
    private TaxDataService service;

    @Test
    public void is_no_tax_declarations_in_empty_repository() {
        TaxDeclarationEntity entity = new TaxDeclarationEntity();
        String taxId = "12345678901";
        when(repository.findByTaxId(taxId)).thenReturn(null);
        TaxDeclarationEntity result = service.getTaxDeclarationByTaxId(taxId);
        assertNull(result);
    }

    @Test
    public void is_return_null_when_no_entity_found() {
        String taxId = "12345678901";
        when(repository.findByTaxId(taxId)).thenReturn(null);
        TaxDeclarationEntity result = service.getTaxDeclarationByTaxId(taxId);
        assertNull(result);
    }

    @Test
    public void is_error_when_empty_taxId() {
        String taxId = "";
        Assertions.assertThrowsExactly(TaxDataService.TaxIdFormatException.class,
                () -> service.getTaxDeclarationByTaxId(taxId));
    }

    @Test
    public void is_error_when_letters_in_taxId() {
        String taxId = "123AVC2";
        Assertions.assertThrowsExactly(TaxDataService.TaxIdFormatException.class,
                () -> service.getTaxDeclarationByTaxId(taxId));
    }

    @Test
    public void is_error_when_numbers_in_taxId_invalid() {
        String taxId = "1";
        Assertions.assertThrowsExactly(TaxDataService.TaxIdFormatException.class,
                () -> service.getTaxDeclarationByTaxId(taxId));
    }

}