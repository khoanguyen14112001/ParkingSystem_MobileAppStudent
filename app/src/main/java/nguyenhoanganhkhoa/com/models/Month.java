package nguyenhoanganhkhoa.com.models;

import java.util.List;

public class Month {
    private String MonthTrans;
    private List<Transaction> transactions;

    public String getMonthTrans() {
        return MonthTrans;
    }

    public void setMonthTrans(String monthTrans) {
        MonthTrans = monthTrans;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Month(String monthTrans, List<Transaction> transactions) {
        MonthTrans = monthTrans;
        this.transactions = transactions;
    }
}
