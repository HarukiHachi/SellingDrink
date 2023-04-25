public class Payment {
    private double amountPaid;
    private double totalPrice;

    public Payment(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getChange() {
        return amountPaid - totalPrice;
    }
}
