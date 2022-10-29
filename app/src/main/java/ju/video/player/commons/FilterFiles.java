/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.commons;

import ju.video.player.model.Format;
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

    private String formatSelected;

    public FilterFiles(String filesFolder, double initSize, double endSize, LocalDate initDate, LocalDate endDate, String formatSelected) {
        this.filesFolder = filesFolder;
        this.initSize = initSize;
        this.endSize = endSize;
        this.initDate = initDate;
        this.endDate = endDate;
        this.formatSelected = formatSelected;
    }

    /**
     * Return a list of files filtered according the criteria entered by the user.
     *
     * @return
     * @throws IOException
     */
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
                // System.out.println(file + " Media:" + verifyIsMediaFile(file) + " - Size:" + verifySize(attributes, initSize, endSize) + " - Date:" + verifyDate(attributes, initDate, endDate));
                if (verifyIsMediaFile(file) && verifySize(attributes, initSize, endSize)
                        && verifyDate(attributes, initDate, endDate)
                        && verifyFormatSelected(file, formatSelected)) {
                    listFilesName.add(fileName);
                }
            }
        }
        return listFilesName;
    }

    /**
     * Verify the file belongs to the format selected in the Combobox.
     *
     * @param file
     * @param formatSelected
     * @return
     * @throws IOException
     */
    public boolean verifyFormatSelected(File file, String formatSelected) throws IOException {
        if (formatSelected == null || formatSelected.isEmpty()) {
            return true;
        }
        String fileContentType = Files.probeContentType(file.toPath());
        Format format = Format.fromString(fileContentType);
        return formatSelected.equals(format.getFormat());
    }

    /**
     * Verify if the file belongs to the format that is manage video player project.
     *
     * @param file
     * @return
     * @throws IOException
     */
    public boolean verifyIsMediaFile(File file) throws IOException {
        String fileContentType = Files.probeContentType(file.toPath());
        Format formats = Format.fromString(fileContentType);
        return formats != null;
    }

    /**
     * Verify if the file accomplish with the criteria of minimun size and maximum size.
     *
     * @param attributes
     * @param initSize
     * @param endSize
     * @return
     */
    public boolean verifySize(BasicFileAttributes attributes, double initSize, double endSize) {
        if (initSize <= 0 || endSize <= 0) {
            return true;
        }
        double fileSize = FileUtil.convertKBToMB(attributes.size());
        return fileSize >= initSize && fileSize <= endSize;
    }

    /**
     * Verify if the file accomplish with the init date and end date criteria.
     *
     * @param attributes
     * @param initDate
     * @param endDate
     * @return
     */
    public boolean verifyDate(BasicFileAttributes attributes, LocalDate initDate, LocalDate endDate) {
        if (initDate == null || endDate == null) {
            return true;
        }
        LocalDate creationDate = attributes.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (creationDate.isAfter(initDate) || creationDate.isEqual(initDate)) && (creationDate.isBefore(endDate) || creationDate.isEqual(endDate));
    }
}
