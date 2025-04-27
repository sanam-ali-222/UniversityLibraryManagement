package beanclasses;

public class BookIssueBean {

    private int issuedId;
    private int bookId;
    private int stdId;
    private String dateOfIssue;
    private String dateOfReturn;
    private int finePanalityAmount;    
    private String remarks;

    public int getIssuedId() {
        return issuedId;
    }

    public void setIssuedId(int issuedId) {
        this.issuedId = issuedId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getFinePanalityAmount() {
        return finePanalityAmount;
    }

    public void setFinePanalityAmount(int finePanalityAmount) {
        this.finePanalityAmount = finePanalityAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }    

    public String toString() {
        return dateOfIssue;
    }
}