package com.example.medvedomg.urantestapp.ui.model;

import java.util.Date;

/**
 * Created by medvedomg on 28.12.16.
 */

public class FileModel {
    private String mFileName;
    private Boolean mIsFolder;
    private Date modDate;
    private FileType fileType;
    private boolean isOrange;
    private boolean isBlue;

//    public FileModel(String mFileName, Boolean mIsFolder, Date modDate, FileType fileType, boolean isOrange, boolean isBlue) {
//        this.mFileName = mFileName;
//        this.mIsFolder = mIsFolder;
//        this.modDate = modDate;
//        this.fileType = fileType;
//        this.isOrange = isOrange;
//        this.isBlue = isBlue;
//    }

    public String getFileName() {
        return mFileName;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public boolean isOrange(boolean chectBar) {
        return isOrange;
    }

    public FileType getFileType() {
        return fileType;
    }

    public Date getModDate() {
        return modDate;
    }

    public Boolean getIsFolder() {
        return mIsFolder;
    }

    public void setFileName(String mFileName) {
        this.mFileName = mFileName;
    }

    public void setIsFolder(Boolean mIsFolder) {
        this.mIsFolder = mIsFolder;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public void setOrange(boolean orange) {
        isOrange = orange;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }
}
