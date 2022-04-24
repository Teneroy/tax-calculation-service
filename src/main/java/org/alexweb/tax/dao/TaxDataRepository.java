package org.alexweb.tax.dao;

import org.alexweb.tax.entities.TaxDeclarationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaxDataRepository extends MongoRepository<TaxDeclarationEntity, String> {
    List<TaxDeclarationEntity> findAll();

    TaxDeclarationEntity findByTaxId(String taxId);
}
