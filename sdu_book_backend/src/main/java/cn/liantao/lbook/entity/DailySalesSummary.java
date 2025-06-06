package cn.liantao.lbook.entity;

public class DailySalesSummary {
    private String date; // yyyy-MM-dd
    private int totalCount;
    private double totalAmount;

    // 构造函数
    public DailySalesSummary(String date, int totalCount, double totalAmount) {
        this.date = date;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
    }

    // Getter 和 Setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
