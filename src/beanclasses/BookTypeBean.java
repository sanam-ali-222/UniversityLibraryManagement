package beanclasses;

public class BookTypeBean {

    private int typeId;
    private String type;
    private String remarks;

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    } 

    public int getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    public String getRemarks() {
        return remarks;
    }

    public String toString() {
        return type;
    }
}