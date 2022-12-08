package com.bdortho.stock.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product;
    private String qty;
    private String price;
    private String discount;
    private String total;

    @ManyToOne
    @JoinColumn(name="purchaseModel_id")
    private PurchaseModel purchaseModel;
}
