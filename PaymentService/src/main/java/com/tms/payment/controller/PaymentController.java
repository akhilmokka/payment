package com.tms.payment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.payment.model.Payment;
import com.tms.payment.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService service;

	@PostMapping("/create/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		return service.savePayment(payment);
	}

	@GetMapping("/getall/payments")
	public List<Payment> GetAllPayments() {
		return service.GetAllPaymentsInfo();
	}

	@GetMapping("/get/payment/id")
	public Payment GetPaymentById(@PathVariable UUID payment_Id) {
		return service.GetPaymentByPaymentId(payment_Id);
	}

	@PutMapping("/update/id")
	public Payment UpdatePayment(@RequestBody Payment payment, @PathVariable UUID payment_id) {
		return service.UpdatePaymentById(payment, payment_id);
	}

	@DeleteMapping("/delete/{id}")
	public String DeletePayment(@PathVariable UUID payment_id) {
		return service.DeletePaymentById(payment_id);
	}

}
