/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanclasses;

/**
 *
 * @author Amjad Jamali
 */
public class DepartmentBean {
    private int deptId;
    private String deptName;
    private String remarks;


    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDeptId() {
        return deptId;
    }
 
    public String getDeptName() {
        return deptName;
    }

    public String getRemarks() {
        return remarks;
    }

    public String toString() {
        return deptName;
    }
}
