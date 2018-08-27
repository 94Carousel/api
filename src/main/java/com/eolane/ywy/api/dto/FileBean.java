package com.eolane.ywy.api.dto;

import java.io.Serializable;


public class FileBean implements Serializable{
	private String filePath;
	private String fileName;
	private String fileSize;
	private String fileType;
	private String fileUrl;
	
	public FileBean() {}

	public FileBean(String filePath, String fileName, String fileSize, String fileType, String fileUrl) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileUrl = fileUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
