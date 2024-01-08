package com.virtualvision.erp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno con la entidad Employee
    @JoinColumn(name = "employee_id", nullable = false) // Columna de clave foránea
    private Employee employee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date payPeriodStart; // Inicio del período de pago

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date payPeriodEnd; // Fin del período de pago

    @Column(nullable = false)
    private double grossPay; // Salario bruto

    @Column(nullable = false)
    private double netPay; // Salario neto

    @Column(nullable = false)
    private double taxAmount; // Cantidad de impuestos

    public Payroll() {
    }

    public Payroll(Employee employee, Date payPeriodStart, Date payPeriodEnd, double grossPay, double netPay,
            double taxAmount) {
        this.employee = employee;
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.taxAmount = taxAmount;
    }

}
