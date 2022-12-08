package com.dbp.demo01.config;

public enum STATUS {
    
    STOP("비활성"),
    ACTIVE("활성"),
    BREAKOUT("탈퇴");
    private final String label;
    
    STATUS(String label){
        this.label = label;
    }
    
    STATUS(){
        label="";
    };

    public String getLabel(){
        return label;
    }
}
