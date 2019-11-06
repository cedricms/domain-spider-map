package com.domain.spider.map;

import java.io.File;

import lombok.extern.log4j.Log4j2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import com.domain.spider.map.image.ImageFileType;

@Log4j2
public class DomainSpiderMapGeneratorTest {
    
    @Test
    public void drawGivenNullNullNullThenNull() {
        // Given
        String sourceDataFilePath = null;
        String imageDestinationFilePath = null;
        ImageFileType imageFileType = null;
        
        DomainSpiderMapGenerator domainSpiderMapGenerator = new DomainSpiderMapGenerator();
        
        // When
        File imageDestinationFile = domainSpiderMapGenerator.draw(sourceDataFilePath, imageDestinationFilePath, imageFileType);
        
        // Then
        assertThat(imageDestinationFile).isNull();
    }
}