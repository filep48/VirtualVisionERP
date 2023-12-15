package com.virtualvision.erp.service.supplier;

import java.util.List;

import com.virtualvision.erp.domain.Supplier;

public interface ISupplierService {

    List<Supplier> findAllSuppliers();

    void saveSupplier(Supplier supplier);

    void deleteSupplier(Long id);

    Supplier findSupplierById(Long id);

    void updateSupplier(Supplier supplier);

    Long findIdByName(String name);
    

}
