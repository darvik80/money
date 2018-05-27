package xyz.crearts.money.entity;

public class CashFlowPieChart {
    private long categoryId;
    private String name;
    private double amount;

    public CashFlowPieChart(long categoryId, String name, double amount) {
        this.categoryId = categoryId;
        this.name = name;
        this.amount = amount;
    }

    public CashFlowPieChart() {

    }

    public long getCategoryId() {
        return categoryId;
    }


    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
