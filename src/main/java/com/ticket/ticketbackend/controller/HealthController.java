
package com.ticket.ticketbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthController {

    private final DataSource dataSource;

    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/api/health")
    public String healthCheck() {

        try (Connection connection = dataSource.getConnection()) {

            return "TicketFlow Backend Running Successfully! "
                    + "PostgreSQL Connected: "
                    + connection.getMetaData().getDatabaseProductName();

        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}
