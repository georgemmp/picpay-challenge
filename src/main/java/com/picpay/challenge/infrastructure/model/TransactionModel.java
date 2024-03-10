package com.picpay.challenge.infrastructure.model;

import com.picpay.challenge.domain.type.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction")
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionModel implements Serializable {

    private static final long serialVersionUID = 9171412977344643536L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal paymentValue;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false, name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_transaction",
            joinColumns = {@JoinColumn(name = "transaction_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private List<UserModel> users;
}
