package com.muskmelon.reliable.message.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
	
	private Long id;
	private String content;
	private Integer status;
	private Date createdTime;
	private Date removedTime;
	private Date confirmedTime;
	private Date finishedTime;

}
