package com.devus.noticeservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devus.noticeservice.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	Page<Notice> findAll(Pageable pageable);
}