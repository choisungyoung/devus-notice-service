package com.devus.noticeservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devus.noticeservice.model.Notice;
import com.devus.noticeservice.repository.NoticeRepository;
import com.devus.noticeservice.service.NoticeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;

	@Transactional
	@Override
	public Notice saveNotice(Notice notice) throws Exception {
		return noticeRepository.save(notice);
	}

	@Transactional
	@Override
	public Page<Notice> findNotice(Pageable pageable) {
		return noticeRepository.findAll(pageable);
	}

}
