package com.pw.lhpaymentsvc.dto.receipt;

import com.pw.lhpaymentsvc.dto.CustomerDTO;
import lombok.Data;

import java.util.Date;
@Data
public class GetAllDTO extends ReceiptDTO {
    private double amount;
    private Date date;
    private CustomerDTO customer;
}
