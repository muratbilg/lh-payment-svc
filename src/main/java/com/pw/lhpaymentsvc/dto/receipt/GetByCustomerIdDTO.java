package com.pw.lhpaymentsvc.dto.receipt;

import lombok.Data;

import java.util.Date;

@Data
public class GetByCustomerIdDTO extends ReceiptDTO{

    private double amount;
    private Date date;
}
