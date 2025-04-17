package com.invoice.service.Repositories;

import com.invoice.service.Entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findAllByUserId(String user);
}
