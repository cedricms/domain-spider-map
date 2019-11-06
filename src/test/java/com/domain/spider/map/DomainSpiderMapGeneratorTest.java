package com.domain.spider.map;

import java.io.File;
import java.io.IOException;

import lombok.extern.log4j.Log4j2;

import org.apache.commons.io.FileUtils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import com.domain.spider.map.image.ImageFileType;

@Log4j2
public class DomainSpiderMapGeneratorTest {
    
    private static final String TARGET_TEST_PATH = "./target/test/images/";
    
    protected File testRootDirectoryFile;
    
    @Before
    public void setUp() throws IOException {
        testRootDirectoryFile = new File(TARGET_TEST_PATH);
        
        cleanTestFileDirectory();
        
        if (!testRootDirectoryFile.exists()) {
            testRootDirectoryFile.mkdir();
        }
    }
    
    protected void cleanTestFileDirectory() throws IOException {
        try {
            if (testRootDirectoryFile.exists()) {
                FileUtils.deleteDirectory(testRootDirectoryFile);
            }
        } catch (IOException ioe) {
            throw new IOException("Unable to delete : " + testRootDirectoryFile);
        }
    }
    
    @Test
    public void generateGivenNullNullNullThenNull() {
        // Given
        String sourceDataFilePath = null;
        String imageDestinationFilePath = null;
        ImageFileType imageFileType = null;
        
        DomainSpiderMapGenerator domainSpiderMapGenerator = new DomainSpiderMapGenerator();
        
        // When
        File imageDestinationFile = domainSpiderMapGenerator.generate(sourceDataFilePath, imageDestinationFilePath, imageFileType);
        
        // Then
        assertThat(imageDestinationFile).isNull();
    }
        
    @Test
    public void generateGivenEmptyFileAndDestinationFileAndJpgThenEmptyFile() {
        // Given
        String sourceDataFilePath = "./EmptyTest.json";
        String imageDestinationFilePath = TARGET_TEST_PATH + "EmptyTestResult.jpg";
        ImageFileType imageFileType = ImageFileType.JPG;
        
        DomainSpiderMapGenerator domainSpiderMapGenerator = new DomainSpiderMapGenerator();
        
        // When
        File imageDestinationFile = domainSpiderMapGenerator.generate(sourceDataFilePath, imageDestinationFilePath, imageFileType);
        log.debug("imageDestinationFile : " + imageDestinationFile.getAbsolutePath());
        
        // Then
        assertThat(imageDestinationFile).isNotNull();
        assertThat(imageDestinationFile.exists()).isTrue();
    }
}