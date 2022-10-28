/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.controller;

import ju.video.player.model.Formats;
import ju.video.player.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FilterFiles {

    private String filesFolder;
    private double initSize;
    private double endSize;
    private LocalDate initDate;
    private LocalDate endDate;

    public FilterFiles(String filesFolder, double initSize, double endSize, LocalDate initDate, LocalDate endDate) {
        this.filesFolder = filesFolder;
        this.initSize = initSize;
        this.endSize = endSize;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public List<String> getListFiles() throws IOException {
        File paths = new File(filesFolder);
        String[] nameFiles = paths.list();
        List<String> listFilesName = new ArrayList<>();
        for (String fileName : nameFiles) {
            File file = new File(filesFolder, fileName);
            if (file.isDirectory()) {
                for (String fileName2 : file.list()) {
                    File file2 = new File(file, fileName2);
                }
            } else {
                BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                System.out.println(file + " Media:" + verifyIsMediaFile(file) + " - Size:" + verifySize(attributes, initSize, endSize) + " - Date:" + verifyDate(attributes, initDate, endDate));
                if (verifyIsMediaFile(file)
                        && verifySize(attributes, initSize, endSize)
                        && verifyDate(attributes, initDate, endDate)) {
                    listFilesName.add(fileName);
                }
            }
        }
        return listFilesName;
    }

    public boolean verifyIsMediaFile(File file) throws IOException {
        String fileContentType = Files.probeContentType(file.toPath());
        Formats formats = Formats.fromString(fileContentType);
        return formats != null;
    }

    public boolean verifySize(BasicFileAttributes attributes, double initSize, double endSize) {
        if (initSize <= 0 || endSize <= 0) {
            return true;
        }
        double fileSize = FileUtil.convertKBToMB(attributes.size());
        return fileSize >= initSize && fileSize <= endSize;
    }

    public boolean verifyDate(BasicFileAttributes attributes, LocalDate initDate, LocalDate endDate) {
        if(initDate == null || endDate == null) {
            return true;
        }
        LocalDate creationDate = attributes.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (creationDate.isAfter(initDate) || creationDate.isEqual(initDate) )
                && (creationDate.isBefore(endDate) || creationDate.isEqual(endDate));
    }


    public static void main(String[] args) throws IOException {
//        FilterFiles filterFiles = new FilterFiles("d:\\mandar\\test_video\\", 3, 20, LocalDate.of(2019, 12,23), LocalDate.of(2022, 10, 25));
//        FilterFiles filterFiles = new FilterFiles("d:\\mandar\\test_video\\", 0.1, 20, null, null);
        FilterFiles filterFiles = new FilterFiles("d:\\mandar\\test_video\\", 0, 0,
                LocalDate.of(2019, 12,23), LocalDate.of(2022, 10, 20));
        //filterFiles.getListFiles();
        System.out.println(filterFiles.getListFiles());
    }
}
