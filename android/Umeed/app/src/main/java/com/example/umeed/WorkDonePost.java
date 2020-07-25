package com.example.umeed;

public class WorkDonePost {
    // Member variables representing the title and information about the sport.
    private String desc;
    private String empId;
    private String encodedImage;

    public WorkDonePost(String desc, String empId, String encodedImage) {
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
