package com.devus.noticeservice.controller.dto;

import java.util.Date;

import com.devus.noticeservice.model.Notice;

import lombok.Data;

@Data
public class ResNoticeFindDTO {
	private long id;
	private String title;
	private String contents;
	private long hit;
	private Date beginAt;
	private Date expireAt;
	private Date createAt;

	public ResNoticeFindDTO(Notice dto) {
		this.id = dto.getId();
		this.title = dto.getTitle();
		this.contents = dto.getContents();
		this.hit = dto.getHit();
		this.beginAt = dto.getBeginAt();
		this.expireAt = dto.getExpireAt();
		this.createAt = dto.getCreateAt();
	}
}