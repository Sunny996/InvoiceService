package com.invoice;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(MINIMUM_FARE, totalFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride : rides) {
            fare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, fare);
    }
}
