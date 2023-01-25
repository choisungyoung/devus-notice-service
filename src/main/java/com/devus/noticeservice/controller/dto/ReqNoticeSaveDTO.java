package com.devus.noticeservice.controller.dto;

import java.time.LocalDateTime;

import com.devus.noticeservice.model.Notice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReqNoticeSaveDTO {
	@NotNull
	@Size(max = 10, message = "제목은 100자 이내로 입력해주세요.")
	private String title;
	@NotNull
	@Size(max = 15, message = "내용은 10000자 이내로 입력해주세요.")
	private String contents;
	@NotNull
	@Size(max = 19, message = "게시시작일은 19자 이내로 입력해주세요.")
	private String beginAt;
	@NotNull
	@Size(max = 19, message = "게시종료일은 19자 이내로 입력해주세요.")
	private String expireAt;

	public Notice toModel() {
		LocalDateTime ba = LocalDateTime.parse(beginAt);
		LocalDateTime ea = LocalDateTime.parse(expireAt);

		return Notice.builder().title(title).contents(contents).beginAt(ba).expireAt(ea).build();
	}
}