package beanclasses;

/**
 * @author Amjad Jamali
 */

public class BatchBean {
    private int progId;
    private int batchId;
    private String batchYear;
    private String groupDesc;
    private String remarks;

    public void setProgId(int progId) {
        this.progId = progId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public void setBatchYear(String batchYear) {
        this.batchYear = batchYear;
    }


    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public int getProgId() {
        return progId;
    }

    public int getBatchId() {
        return batchId;
    }

    public String getBatchYear() {
        return batchYear;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public String getRemarks() {
        return remarks;
    }
    public String toString() {
        return batchYear;
    }

}
