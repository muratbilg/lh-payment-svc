package com.pw.lhpaymentsvc.controller;

import com.pw.lhpaymentsvc.domain.Receipt;
import com.pw.lhpaymentsvc.dto.CustomerDTO;
import com.pw.lhpaymentsvc.dto.receipt.GetAllDTO;
import com.pw.lhpaymentsvc.dto.receipt.GetByCustomerIdDTO;
import com.pw.lhpaymentsvc.dto.receipt.ReceiptDTO;
import com.pw.lhpaymentsvc.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping("/list")
    public List<GetAllDTO> getAll() {

        var receipts = receiptRepository.findAll();
        return receipts.stream().map(receipt -> {
            var dto = new GetAllDTO();
            dto.setId(receipt.getId());
            dto.setAmount(receipt.getAmount());
            var customerDTO = new CustomerDTO();
            customerDTO.setFirstName("fn_"+receipt.getCustomerId());
            customerDTO.setLastName("ln_" + receipt.getCustomerId());
            customerDTO.setId(receipt.getCustomerId());
            dto.setCustomer(new CustomerDTO());
            return dto;
            }
        ).collect(Collectors.toList());
    }

    @PostMapping
    public Receipt addReceipt(@RequestBody Receipt receipt) {
        receiptRepository.save(receipt);
        return receipt;
    }

    @GetMapping
    public List<Receipt> getReceiptsByCustomerId(@RequestParam String customerId) {
        return receiptRepository.findByCustomerId(customerId);
    }

}
