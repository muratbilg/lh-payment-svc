package com.pw.lhpaymentsvc.repository;

import com.pw.lhpaymentsvc.domain.Receipt;
import com.pw.lhpaymentsvc.dto.receipt.GetByCustomerIdDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends MongoRepository<Receipt,String> {
  List<Receipt> findByCustomerId(String customerId);
}
