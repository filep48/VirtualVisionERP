
-- INSERT INTO Customer (name, surname, username, password, dni_nif, phone, email, address, role)
-- VALUES ('Ana', 'González', 'ana_gonzalez', 'ana123', '12345678A', '612345678', 'ana.gonzalez@example.com', 'Calle Falsa 123, Madrid', 'user');

-- INSERT INTO Customer (name, surname, username, password, dni_nif, phone, email, address, role)
-- VALUES ('Carlos', 'Pérez', 'carlos_perez', 'carlos123', '87654321B', '698765432', 'carlos.perez@example.com', 'Av. Principal 456, Barcelona', 'user');

-- INSERT INTO Customer (name, surname, username, password, dni_nif, phone, email, address, role)
-- VALUES ('Laura', 'Martínez', 'laura_martinez', 'laura123', '23456789C', '678912345', 'laura.martinez@example.com', 'Plaza Mayor 789, Valencia', 'user');

-- INSERT INTO Customer (name, surname, username, password, dni_nif, phone, email, address, role)
-- VALUES ('Diego', 'López', 'diego_lopez', 'diego123', '98765432D', '654321987', 'diego.lopez@example.com', 'Calle Nueva 101, Sevilla', 'user');

-- -- Creacion de empleados

-- INSERT INTO Employee (name, surname, username, password, dni_nif, phone, email, address, role, position, num_ss, salary)
-- VALUES ('Admin', 'Admin', 'admin', 'admin', '00000000A', '600000000', 'admin@example.com', 'Admin Address 1', 'admin', 'Administrator', 'SSN001', 3000.00);

-- INSERT INTO Employee (name, surname, username, password, dni_nif, phone, email, address, role, position, num_ss, salary)
-- VALUES ('Gerard', 'Albesa', 'gerard_albesa', '1234', '11111111B', '601234567', 'gerard.albesa@example.com', 'Calle Albesa 2', 'employee', 'Developer', 'SSN002', 2000.00);
-- -- Kevin Vasquez
-- INSERT INTO Employee (name, surname, username, password, dni_nif, phone, email, address, role, position, num_ss, salary)
-- VALUES ('Kevin', 'Vasquez', 'kevin_vasquez', '1234', '22222222C', '602345678', 'kevin.vasquez@example.com', 'Avenida Vasquez 3', 'employee', 'Designer', 'SSN003', 2000.00);

-- INSERT INTO Employee (name, surname, username, password, dni_nif, phone, email, address, role, position, num_ss, salary)
-- VALUES ('Vanessa', 'Pedrola', 'vanessa_pedrola', '1234', '33333333D', '603456789', 'vanessa.pedrola@example.com', 'Plaza Pedrola 4', 'employee', 'Analyst', 'SSN004', 2000.00);

-- -- creacion de proveedores
-- INSERT INTO Supplier (name, address, phone, email, contact, description, web, account_number)
-- VALUES ('Meta', '1 Hacker Way, Menlo Park, CA 94025, USA', '650-543-4800', 'contact@meta.com', 'Mark Zuckerberg', 'Leading technology company focused on bringing the world closer together through virtual reality and other means.', 'https://www.meta.com', 'US1234567890');

-- INSERT INTO Supplier (name, address, phone, email, contact, description, web, account_number)
-- VALUES ('PCComponentes', 'Calle Noruega, 174, 30820 Alcantarilla, Murcia, Spain', '+34 968 97 79 78', 'info@pccomponentes.com', 'Alfonso Tomás', 'Spanish retailer specializing in computers and technology, including virtual reality products.', 'https://www.pccomponentes.com', 'ES0987654321');

-- INSERT INTO Supplier (name, address, phone, email, contact, description, web, account_number)
-- VALUES ('Sony', '1-7-1 Konan, Minato-ku, Tokyo 108-0075, Japan', '+81 3-6748-2111', 'contact@sony.com', 'Kenichiro Yoshida', 'Multinational conglomerate corporation known for its electronic products, including the PlayStation VR.', 'https://www.sony.com', 'JP123456789012');

-- INSERT INTO Supplier (name, address, phone, email, contact, description, web, account_number)
-- VALUES ('HTC Vive', '23 Xinghua Rd, Taoyuan District, Taoyuan City, Taiwan 330', '+886 3-375-3252', 'contact@htcvive.com', 'Cher Wang', 'A leading company in innovative smart mobile and virtual reality technology.', 'https://www.vive.com', 'TW123456789');

-- -- creacion de productos

-- INSERT INTO Product (supplier_id, name, description, quantity, price)
-- VALUES (1, 'Oculus Quest 2', 'Gafas de realidad virtual inalámbricas de Meta', 100, 299.99);

-- INSERT INTO Product (supplier_id, name, description, quantity, price)
-- VALUES (2, 'ASUS ROG Strix GeForce RTX 3080', 'Tarjeta gráfica para gaming y experiencias de realidad virtual', 50, 699.99);

-- INSERT INTO Product (supplier_id, name, description, quantity, price)
-- VALUES (3, 'PlayStation VR', 'Sistema de realidad virtual para la consola PlayStation', 150, 199.99);

-- INSERT INTO Product (supplier_id, name, description, quantity, price)
-- VALUES (4, 'HTC Vive Cosmos Elite', 'Casco de realidad virtual con seguimiento de precisión', 80, 899.99);

-- -- creacion de nominas
-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (1, '2024-01-01', '2024-01-31', 3000.00, 2700.00, 300.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (1, '2024-02-01', '2024-02-28', 3000.00, 2700.00, 300.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (2, '2024-01-01', '2024-01-31', 2000.00, 1800.00, 200.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (2, '2024-02-01', '2024-02-28', 2000.00, 1800.00, 200.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (3, '2024-01-01', '2024-01-31', 2000.00, 1800.00, 200.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (3, '2024-02-01', '2024-02-28', 2000.00, 1800.00, 200.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (4, '2024-01-01', '2024-01-31', 2000.00, 1800.00, 200.00);

-- INSERT INTO Payroll (employee_id, pay_period_start, pay_period_end, gross_pay, net_pay, tax_amount) 
-- VALUES (4, '2024-02-01', '2024-02-28', 2000.00, 1800.00, 200.00);

-- INSERT INTO events (name, start_time, end_time, description, is_paid, price, location, capacity, organizer)
-- VALUES ('Demostración VR: Mundo Virtual', '2024-03-10 10:00:00', '2024-03-10 16:00:00', 'Una experiencia interactiva con los últimos juegos de realidad virtual.', FALSE, 0.00, 'Local VR Central', 50, 'VR Gaming Co.');

-- INSERT INTO events (name, start_time, end_time, description, is_paid, price, location, capacity, organizer)
-- VALUES ('Alquiler de Espacio VR', '2024-03-15 18:00:00', '2024-03-15 21:00:00', 'Alquiler de espacio para sesiones privadas de juegos VR.', TRUE, 200.00, 'Sala VR Experiencia', 20, 'Virtual Vision');

-- INSERT INTO events (name, start_time, end_time, description, is_paid, price, location, capacity, organizer)
-- VALUES ('Lanzamiento: Aventura Cósmica VR', '2024-04-05 17:00:00', '2024-04-05 20:00:00', 'Presentación y prueba del nuevo juego Aventura Cósmica VR.', TRUE, 150.00, 'Auditorio Tech VR', 100, 'Galaxy Games');

-- INSERT INTO events (name, start_time, end_time, description, is_paid, price, location, capacity, organizer)
-- VALUES ('Conferencia VR: El Futuro Digital', '2024-04-20 09:00:00', '2024-04-20 12:00:00', 'Una conferencia sobre las tendencias y el futuro de la realidad virtual.', FALSE, 0.00, 'Centro de Convenciones Virtual', 200, 'VR Innovators');

-- -- Inserciones para la tabla event_employee
-- -- empleados con el evento 1
-- INSERT INTO event_employee (event_id, employee_id) VALUES (1, 1); -- Admin con evento 1
-- INSERT INTO event_employee (event_id, employee_id) VALUES (1, 2); -- Gerard con evento 1

-- -- empleados con el evento 2
-- INSERT INTO event_employee (event_id, employee_id) VALUES (2, 3); -- Kevin con evento 2
-- INSERT INTO event_employee (event_id, employee_id) VALUES (2, 4); -- Vanessa con evento 2

-- -- Inserciones para la tabla event_customer
-- -- clientes con el evento 1
-- INSERT INTO event_customer (event_id, customer_id) VALUES (1, 1);
-- INSERT INTO event_customer (event_id, customer_id) VALUES (1, 2);

-- -- clientes con el evento 2
-- INSERT INTO event_customer (event_id, customer_id) VALUES (2, 3);
-- INSERT INTO event_customer (event_id, customer_id) VALUES (2, 4);



