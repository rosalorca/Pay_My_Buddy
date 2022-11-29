package com.openclassrooms.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
@Data
@DynamicUpdate

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "account_id")
    private int account_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "balance")
    private double balance;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "transfer_id")
    List<Transfer> operations = new ArrayList<>();

    public void addTransfer(Transfer transfer) {
        operations.add(transfer);
        transfer.getAccounts().add(this);
    }

    public void removeTransfer(Transfer transfer) {
        operations.remove(transfer);
        transfer.getAccounts().remove(this);
    }

}
