package com.devus.noticeservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devus.noticeservice.common.exception.ValidationException;
import com.devus.noticeservice.controller.dto.ReqNoticeSaveDTO;
import com.devus.noticeservice.controller.dto.ResNoticeFindDTO;
import com.devus.noticeservice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notice")
public class NoticeController {

	private final NoticeService noticeService;

	@GetMapping("")
	public ResponseEntity<?> findNotice(@PageableDefault Pageable pageable) throws Exception {
		return ResponseEntity.ok(noticeService.findNotice(pageable).map(p -> {
			return new ResNoticeFindDTO(p);
		}));
	}

	@PostMapping
	public ResponseEntity<?> saveNotice(@Validated @RequestBody ReqNoticeSaveDTO dto, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
        }
		
		return ResponseEntity.ok(new ResNoticeFindDTO(noticeService.saveNotice(dto.toModel())));
	}
}
