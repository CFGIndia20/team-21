package com.example.umeed;

public class WorkData {

    private String desc;
    private String empId;
    private String encodedImage;

    public WorkData(String desc, String empId,String encodedImage) {
        this.desc = desc;
        this.empId = empId;
        this.encodedImage = encodedImage;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEncodedImage() {
        return encodedImage;
    }
}
