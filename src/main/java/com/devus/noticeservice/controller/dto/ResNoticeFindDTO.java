package com.devus.noticeservice.controller.dto;

import com.devus.noticeservice.common.util.DateUtil;
import com.devus.noticeservice.model.Notice;

import lombok.Data;

@Data
public class ResNoticeFindDTO {
	private long id;
	private String title;
	private String contents;
	private long hit;
	private String beginAt;
	private String expireAt;
	private String createAt;

	public ResNoticeFindDTO(Notice model) {
		this.id = model.getId();
		this.title = model.getTitle();
		this.contents = model.getContents();
		this.hit = model.getHit();
		this.beginAt = model.getBeginAt().format(DateUtil.getDateTimeFormat());
		this.expireAt = model.getExpireAt().format(DateUtil.getDateTimeFormat());
		this.createAt = model.getCreatedAt().format(DateUtil.getDateTimeFormat());
	}
}