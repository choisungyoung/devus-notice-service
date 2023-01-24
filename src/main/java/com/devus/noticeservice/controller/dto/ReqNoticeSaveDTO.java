package com.devus.noticeservice.controller.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.devus.noticeservice.model.Notice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Size(max = 18, message = "일자는 18자 이내로 입력해주세요.")
	private String beginAt;
	@NotNull
	@Size(max = 18, message = "일자는 18자 이내로 입력해주세요.")
	private String expireAt;

	public Notice toModel() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ba = null, ea = null;
		try {
			ba = df.parse(beginAt);
			ea = df.parse(expireAt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Notice.builder()
				.title(title)
				.contents(contents)
				.beginAt(ba)
				.expireAt(ea)
				.build();
	}
}