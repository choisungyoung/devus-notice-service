package com.devus.noticeservice.controller.dto;

import java.util.Date;

import com.devus.noticeservice.model.Notice;

import lombok.Data;

@Data
public class ReqNoticeSaveDTO {
	private String title;
	private String contents;
	private Date beginAt;
	private Date expireAt;
	private Date createAt;

	public Notice toModel() {
		return Notice.builder()
				.title(title)
				.contents(contents)
				.beginAt(beginAt)
				.expireAt(expireAt)
				.createAt(createAt)
				.build();
	}
}