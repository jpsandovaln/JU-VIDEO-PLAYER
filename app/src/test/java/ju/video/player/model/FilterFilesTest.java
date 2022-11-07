package ju.video.player.model;

import ju.video.player.commons.exceptions.ContentFileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;

public class FilterFilesTest {
    private FilterFiles filterFiles;

    @Test
    public void verifyFileFormatIsValid() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("small.mp4").getFile());
        filterFiles = new FilterFiles(0, 0, null, null, "");
        try {
            boolean result = filterFiles.verifyFormatSelected(file, Format.VIDEO_MP4.getFormat());
            Assert.assertTrue(result);
        } catch (ContentFileException e) {
            Assert.fail("The file should be valid");
        }
    }

    @Test
    public void verifyFileFormatIsNotValid() throws ContentFileException {
        File file = new File("notice.txt");
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyFormatSelected(file, Format.VIDEO_MP4.getFormat());
        Assert.assertFalse(result);
    }

    @Test
    public void verifyValidateFormatSelectedIsNull() throws ContentFileException {
        File file = new File("notice.txt");
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyFormatSelected(file, null);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyValidateFormatSelectedIsEmpty() throws ContentFileException {
        File file = new File("notice.txt");
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyFormatSelected(file, "");
        Assert.assertTrue(result);
    }

    @Test
    public void verifyFileNotExist() throws ContentFileException {
        File file = new File("notice.txt");
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyFormatSelected(file, "");
        Assert.assertTrue(result);
    }

    @Test
    public void verifySizeFileIsInRange() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifySize(attributes, 0, 5);
        Assert.assertTrue(result);
    }

    @Test
    public void verifySizeFileIsNotInRange() throws IOException {
        // Getting the file route such as.
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifySize(attributes, 5, 20);
        Assert.assertFalse(result);
    }

    @Test
    public void verifySizeFileIsInRangeDouble() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifySize(attributes, 0.1, 0.7);
        Assert.assertTrue(result);
    }

    // It was done to desactivate the filter size, if it happens, the filter is desactivite in the UI.
    @Test
    public void verifySizeFileIsInRangeZero() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifySize(attributes, 0, 0);
        Assert.assertTrue(result);
    }

    // It was done to desactivate the filter size, if it happens, the filter is desactivite in the UI.
    @Test
    public void verifySizeFileIsInRangeLessZero() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributesFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifySize(attributesFile, -3, -5);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyInitDateOfTheFileToSearchIsNull() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributesFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyDate(attributesFile, null, LocalDate.now());
        Assert.assertTrue(result);
    }

    @Test
    public void verifyEndDateOfTheFileToSearchIsNull() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributesFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyDate(attributesFile, LocalDate.now(), null);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyBothRangeDatesAreNull() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributesFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyDate(attributesFile, null, null);
        Assert.assertTrue(result);
    }

    @Test
    public void verifyFileIsNotIntheDateRange() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("small.mp4").getFile());
        BasicFileAttributes attributesFile = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        filterFiles = new FilterFiles(0, 0, null, null, "");
        boolean result = filterFiles.verifyDate(attributesFile,
                LocalDate.of(2022, 11, 1),
                LocalDate.of(2022, 11, 2));
        Assert.assertFalse(result);
    }
}
