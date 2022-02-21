package com.epam.spring.service.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal price;

    private Long amount;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    @ColumnDefault("1")
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductDescription> productDescriptionList;

}
