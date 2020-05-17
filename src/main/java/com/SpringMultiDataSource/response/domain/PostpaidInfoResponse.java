package com.SpringMultiDataSource.response.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_POSTPAIDINFO_REQUEST")
public class PostpaidInfoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String subno;
	private String shortcode;
	private String message;
	private String status;
	private String param1;
	private String param2;
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeout;
	
	PostpaidInfoResponse(){}

	public Date getTimeout() {
		return this.timeout;
	}

	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubno() {
		return this.subno;
	}

	public void setSubno(String subno) {
		this.subno = subno;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParam1() {
		return this.param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return this.param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
	    this.description = description;
	  }
}
