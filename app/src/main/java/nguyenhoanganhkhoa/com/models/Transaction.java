package nguyenhoanganhkhoa.com.models;

public class Transaction {
    private String statusTrans;
    private String dateTrans;
    private String moneyTrans;
    private int imgStatusTrans;

    public String getStatusTrans() {
        return statusTrans;
    }

    public void setStatusTrans(String statusTrans) {
        this.statusTrans = statusTrans;
    }

    public String getDateTrans() {
        return dateTrans;
    }

    public void setDateTrans(String dateTrans) {
        this.dateTrans = dateTrans;
    }

    public String getMoneyTrans() {
        return moneyTrans;
    }

    public void setMoneyTrans(String moneyTrans) {
        this.moneyTrans = moneyTrans;
    }

    public int getImgStatusTrans() {
        return imgStatusTrans;
    }

    public void setImgStatusTrans(int imgStatusTrans) {
        this.imgStatusTrans = imgStatusTrans;
    }

    public Transaction(String statusTrans, String dateTrans, String moneyTrans, int imgStatusTrans) {
        this.statusTrans = statusTrans;
        this.dateTrans = dateTrans;
        this.moneyTrans = moneyTrans;
        this.imgStatusTrans = imgStatusTrans;
    }
}
