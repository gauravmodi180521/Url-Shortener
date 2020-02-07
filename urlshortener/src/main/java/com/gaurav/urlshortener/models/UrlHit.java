package com.gaurav.urlshortener.models;

import java.util.Date;

public class UrlHit {
    private String originalUrl;
    private String shortenUrl;
    private Date creationDate;
    private String userId;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getShortenUrl() {
		return shortenUrl;
	}

	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}
    
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UrlHit withoriginalUrl(String url){
		this.originalUrl = url;
		return this;
	}
	
	public UrlHit withshortenUrl(String url){
		this.shortenUrl = url;
		return this;
	}
	
	public UrlHit withcreationDate(Date timestamp){
		this.creationDate = timestamp;
		return this;
	}
	
	public UrlHit withuserId(String id){
		this.shortenUrl = id;
		return this;
	}
}
