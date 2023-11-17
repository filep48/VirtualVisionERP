package com.VirtualVision.VirtualVision.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/* 


@Entity
@Table(name = "Employee")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ssNumber")
    private String ssNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    // Constructor con la clase padre
    public Employee(String email, String name, String surname, String phone, String username, String password,
            String ssNumber) {
        super(email, name, surname, phone, username, password);
        this.ssNumber = ssNumber;
    }

    public Employee() {
        super();
    }
}
*/
