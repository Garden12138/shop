package com.garden.web.utils;
/**
 * 图片生成器
 * @author Garden
 * 2018年6月13日
 */
public class PictureGenerator {
	
	private String hostUrl;
	private String uploadUrl;
	private String downloadUrl;
	public PictureGenerator() {
		super();
	}
	public PictureGenerator(String hostUrl, String uploadUrl, String downloadUrl) {
		super();
		this.hostUrl = hostUrl;
		this.uploadUrl = uploadUrl;
		this.downloadUrl = downloadUrl;
	}
	public String getHostUrl() {
		return hostUrl;
	}
	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	@Override
	public String toString() {
		return "PictureGenerator [hostUrl=" + hostUrl + ", uploadUrl=" + uploadUrl + ", downloadUrl=" + downloadUrl
				+ "]";
	}
}
