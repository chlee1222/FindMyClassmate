package com.example.findmyclassmate;

public class profileData {
    private String dataName;
    private String dataType;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataImage() {
        return dataImage;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    private String dataImage;

    public profileData(String dataName, String dataType, String dataImage) {
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataImage = dataImage;
    }
}
