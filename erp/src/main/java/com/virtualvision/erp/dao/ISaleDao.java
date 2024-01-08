package com.virtualvision.erp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtualvision.erp.domain.Sale;

public interface ISaleDao extends JpaRepository<Sale, Long>{


    /**
     * Optional es una clase "contenedeor" puede tener o no un valor. Evita error de null pointer exception
     * esta query es para traer los detalles de la venta, une las tablas sale, product y customer
     * @param saleId
     * @return
     */
    

    //  @Query("SELECT s FROM Sale s JOIN FETCH s.products JOIN FETCH s.customer c LEFT JOIN FETCH c.employees WHERE s.id = :saleId")
    //  Optional<Sale> findSaleWithDetails(@Param("saleId") Long saleId);
     

    
}
