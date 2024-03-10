package com.picpay.challenge.infrastructure.model;

import com.picpay.challenge.domain.type.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "picpay_user")
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel implements Serializable {

    private static final long serialVersionUID = 6020089696136558574L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String cpfCnpj;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_type")
    private UserType userType;

    @OneToOne(mappedBy = "user")
    private TransactionPinModel transactionPin;

    @OneToOne(mappedBy = "user")
    private WalletModel wallet;

    @ManyToMany(mappedBy = "users")
    private List<TransactionModel> transactionModelList;
}
