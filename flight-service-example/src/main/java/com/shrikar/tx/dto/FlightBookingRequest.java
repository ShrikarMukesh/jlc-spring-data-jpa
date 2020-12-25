package com.shrikar.tx.dto;


import com.shrikar.tx.entity.PassengerInfo;
import com.shrikar.tx.entity.PaymentInfo;



public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;



    public FlightBookingRequest(PassengerInfo passengerInfo, PaymentInfo paymentInfo) {
        this.passengerInfo = passengerInfo;
        this.paymentInfo = paymentInfo;
    }

    public PassengerInfo getPassengerInfo() {
        return passengerInfo;
    }

    public void setPassengerInfo(PassengerInfo passengerInfo) {
        this.passengerInfo = passengerInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}