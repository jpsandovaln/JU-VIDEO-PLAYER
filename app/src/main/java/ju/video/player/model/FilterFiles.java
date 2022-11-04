/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.model;

import ju.video.player.commons.exceptions.ContentFileException;
import ju.video.player.commons.exceptions.FilterFilesException;
import ju.video.player.commons.exceptions.ListVideosException;
import ju.video.player.model.utils.FileUtil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * It is responsible of filter the files
 *
 * @author Maria Hurtado
 * @version 1.0
 */

public class FilterFiles {

    private double initSize;
    private double endSize;
    private LocalDate initDate;
    private LocalDate endDate;

    private String formatSelected;

    public FilterFiles(double initSize, double endSize, LocalDate initDate, LocalDate endDate, String formatSelected) {
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
     * @throws FilterFilesException if there is a problem with the filters
     */

    public List<File> getListFiles() throws FilterFilesException {
        try {
            List<File> listFiles = MediaList.getInstance().getMediaList();
            List<File> listFilteredFiles = new ArrayList<>();
            for (File file : listFiles) {
                //File file = new File(filesFolder, fileName);
                if (file.isDirectory()) {
                    for (String fileName2 : file.list()) {
                        File file2 = new File(file, fileName2);
                    }
                } else {
                    BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    if (verifyIsMediaFile(file) && verifySize(attributes, initSize, endSize)
                            && verifyDate(attributes, initDate, endDate)
                            && verifyFormatSelected(file, formatSelected)) {
                                listFilteredFiles.add(file);
                    }
                    if (listFiles.isEmpty()) {
                        throw new ListVideosException("There are no files of the supported formats in the folder");
                    }
                }
            }
            return listFilteredFiles;
        } catch (ContentFileException e) {
            throw new FilterFilesException(e.getMessage(),e);
        } catch (ListVideosException e) {
            throw new FilterFilesException(e.getMessage(),e);
        } catch (Exception e) {
            throw new FilterFilesException("It's not possible to read one of the files",e);
        }
    }

    /**
     * Verify the file belongs to the format selected in the Combobox.
     *
     * @param file,           is to verify if has the format required by the user.
     * @param formatSelected, it is the format requerired by the user.
     * @return True or False if the file accomplish with the format.
     * @throws ContentFileException if the content type of the file is not valid
     */
    public boolean verifyFormatSelected(File file, String formatSelected) throws ContentFileException {
        try {
            if (formatSelected == null || formatSelected.isEmpty()) {
                return true;
            }
            String fileContentType = Files.probeContentType(file.toPath());
            Format format = Format.fromString(fileContentType);
            return formatSelected.equals(format.getFormat());
        } catch (Exception e) {
            throw new ContentFileException("The content type of the file is not valid", e);
        }
    }

    /**
     * Verify if the file belongs to the format that is manage video player project.
     *
     * @param file
     * @return
     * @throws ContentFileException if the content type of the file is not valid
     */
    public boolean verifyIsMediaFile(File file) throws ContentFileException {
        try {
            String fileContentType = Files.probeContentType(file.toPath());
            Format formats = Format.fromString(fileContentType);
            return formats != null;
        } catch (Exception e) {
            throw new ContentFileException("The content type of the file is not valid", e);
        }
    }

    /**
     * Verify if the file accomplish with the criteria of minimun size and maximum
     * size.
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
        return (creationDate.isAfter(initDate) || creationDate.isEqual(initDate))
                && (creationDate.isBefore(endDate) || creationDate.isEqual(endDate));
    }
}
