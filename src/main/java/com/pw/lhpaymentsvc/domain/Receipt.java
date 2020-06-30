package com.pw.lhpaymentsvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Receipt")
public class Receipt {
    @Id
    private String id;
    private Double amount;
    private String customerId;
    private Date date;
}
