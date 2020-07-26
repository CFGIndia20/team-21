package com.example.umeed;

public class WorkData {

    private String desc;
    private String empId;
    private String encodedImage;
    private String verify;
    private String id;

    public WorkData(String desc, String empId,String encodedImage, String verify, String id) {
        this.desc = desc;
        this.empId = empId;
        this.encodedImage = encodedImage;
        this.verify = verify;
        this.id = id;
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

    public String getVerify() {
        return verify;
    }

    public String getId() {
        return id;
    }
}
