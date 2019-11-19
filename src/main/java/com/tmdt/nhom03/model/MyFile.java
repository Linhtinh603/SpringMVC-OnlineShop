package com.tmdt.nhom03.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MyFile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MultipartFile multipartFile;
	 
	
	public MyFile(MultipartFile multipartFile) {
		super();
		this.multipartFile = multipartFile;
	}
	public MyFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "MyFile [multipartFile=" + multipartFile + "]";
	}
	
}