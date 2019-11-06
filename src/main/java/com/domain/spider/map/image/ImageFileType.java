package com.domain.spider.map.image;

public enum ImageFileType {
    
    JPG("jpg"),
    PNG("png"),
    SVG("svg");
    
    String type;
    
    private ImageFileType(String type) {
        this.type = type;
    }
    
    public String toString(){
        return this.type;
    }
}