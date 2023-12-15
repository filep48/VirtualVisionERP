package com.virtualvision.erp.service.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.ISupplierDao;
import com.virtualvision.erp.domain.Supplier;

@Service
public class SupplierServiceImp implements ISupplierService {
    @Autowired
    private ISupplierDao supplierDao;

    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierDao.findAll();
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierDao.deleteById(id);
    }

    @Override
    public Supplier findSupplierById(Long id) {
        return supplierDao.findById(id).orElse(null);
    }

    @Override
    public Long findIdByName(String name) {
        Supplier supplier = supplierDao.findByName(name);
        return supplier != null ? supplier.getId() : null;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDao.save(supplier);
    }

}
