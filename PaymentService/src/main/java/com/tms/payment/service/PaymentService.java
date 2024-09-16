package com.tms.payment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.payment.model.Payment;
import com.tms.payment.respository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repo;

	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub
		return repo.save(payment);
	}

	public List<Payment> GetAllPaymentsInfo() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Payment GetPaymentByPaymentId(UUID payment_Id) {
		// TODO Auto-generated method stub
		return repo.findById(payment_Id).get();
	}

	public Payment UpdatePaymentById(Payment payment, UUID payment_id) {
		// TODO Auto-generated method stub
		return repo.findById(payment_id).map(data -> {
		    data.setAmount(payment.getAmount());
		    data.setPaymentMethod(payment.getPaymentMethod());
		    data.setPaymentStatus(payment.getPaymentStatus());
		    return repo.save(data);
		}).orElseThrow(() -> new RuntimeException("Payment not found with id: " + payment_id));

	}

	public String DeletePaymentById(UUID payment_id) {
		// TODO Auto-generated method stub
		repo.deleteById(payment_id);
		return "Payment with "+payment_id+" has been deleted Successfully..!";
	}
}
