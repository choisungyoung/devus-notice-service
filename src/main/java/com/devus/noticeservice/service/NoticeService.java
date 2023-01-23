package com.devus.noticeservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devus.noticeservice.model.Notice;

public interface NoticeService {
	Notice saveNotice(Notice notice) throws Exception;

	Page<Notice> findNotice(Pageable pageable);
}
