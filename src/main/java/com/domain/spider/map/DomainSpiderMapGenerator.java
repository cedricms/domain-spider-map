package com.domain.spider.map;

import java.io.File;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

import com.domain.spider.map.image.ImageFileType;

@Log4j2
public class DomainSpiderMapGenerator {
    
    public File generate(String sourceDataFilePath, String imageDestinationFilePath, ImageFileType imageFileType) {
        if (validateInputs(sourceDataFilePath, imageDestinationFilePath, imageFileType)) {
            File sourceDataFile = new File(sourceDataFilePath);
            
            File imageDestinationFile = initlizeImageDestinationFile(imageDestinationFilePath);            
            
            switch (imageFileType) {
                case JPG :
                    return drawJpg(sourceDataFile, imageDestinationFile);
                case PNG :
                    return drawPng(sourceDataFile, imageDestinationFile);
                case SVG :
                    return drawSvg(sourceDataFile, imageDestinationFile);
                default :
                    return null;
            }
        } else {
            return null;
        }
    }
    
    private File initlizeImageDestinationFile(String imageDestinationFilePath) {
        File imageDestinationFile = new File(imageDestinationFilePath);
        
        if (imageDestinationFile != null) {
            if (!imageDestinationFile.getParentFile().exists()) {
                if (!imageDestinationFile.getParentFile().mkdirs()) {
                    log.error("Cannot create directory : " + imageDestinationFile.getParentFile().getAbsolutePath());   
                }
            }
            
            if (!imageDestinationFile.exists()) {
                try {
                    imageDestinationFile.createNewFile();
                } catch (IOException ioe) {
                    log.error("Cannot create file : " + imageDestinationFilePath, ioe);   
                }
            }
        }
        
        return imageDestinationFile;
    }
    
    private File drawJpg(File sourceDataFile, File imageDestinationFile) {
        return imageDestinationFile;
    }
    
    private File drawPng(File sourceDataFile, File imageDestinationFile) {
        return imageDestinationFile;
    }
    
    private File drawSvg(File sourceDataFile, File imageDestinationFile) {
        return imageDestinationFile;
    }
    
    private boolean validateInputs(String sourceDataFilePath, String imageDestinationFilePath, ImageFileType imageFileType) {
        if ((sourceDataFilePath == null)
            || (imageDestinationFilePath == null)
            || (imageFileType == null)) {
            return false;
        } else {
            return true;
        }
    }
}
