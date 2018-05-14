package xyz.crearts.money.entity;

public class CashFlowPieChart {
    private Long categoryId;
    private String name;
    private Double amount;

    public CashFlowPieChart(Long categoryId, String name, Double amount) {
        this.categoryId = categoryId;
        this.name = name;
        this.amount = amount;
    }

    public CashFlowPieChart() {

    }

    public Long getCategoryId() {
        return categoryId;
    }


    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }
}
