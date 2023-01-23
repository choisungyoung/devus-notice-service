package com.devus.noticeservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devus.noticeservice.controller.dto.ReqNoticeSaveDTO;
import com.devus.noticeservice.controller.dto.ResNoticeFindDTO;
import com.devus.noticeservice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {

	private final NoticeService noticeService;

	@GetMapping("/")
	public Page<ResNoticeFindDTO> findNotice(@PageableDefault Pageable pageable) throws Exception {
		return noticeService.findNotice(pageable).map(p -> {
			return new ResNoticeFindDTO(p);
		});
	}

	@PostMapping
	public ResNoticeFindDTO saveNotice(@RequestBody() ReqNoticeSaveDTO dto) throws Exception {
		return new ResNoticeFindDTO(noticeService.saveNotice(dto.toModel()));
	}
}
