package com.tms.payment.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,UUID>{

}
