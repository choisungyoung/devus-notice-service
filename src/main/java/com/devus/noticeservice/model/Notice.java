package com.devus.noticeservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@SequenceGenerator(name = "DVS_NOTICE_SEQ_GEN", sequenceName = "DVS_NOTICE_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "DVS_NOTICE")
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DVS_NOTICE_SEQ_GEN")
	private long id;

	@Column
	private String title;

	@Column(columnDefinition = "TEXT")
	private String contents;

	@Column(nullable = false)
	private long hit = 0;

	@Column(nullable = false)
	private LocalDateTime beginAt;

	@Column(nullable = false)
	private LocalDateTime expireAt;
}