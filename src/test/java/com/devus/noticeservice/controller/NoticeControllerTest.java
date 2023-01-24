package com.devus.noticeservice.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.devus.noticeservice.controller.dto.ReqNoticeSaveDTO;
import com.devus.noticeservice.model.Notice;
import com.google.gson.Gson;

@ExtendWith(RestDocumentationExtension.class)
@SpringBootTest
public class NoticeControllerTest {
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation)).build();
	}

	@Test
	public void getNoticeTest() throws Exception {
		this.mockMvc.perform(get("/api/notice").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(document("get-notice"));
	}

	@Test
	public void saveNoticeTest() throws Exception {
		Calendar cal = Calendar.getInstance();
	    Date d = new Date(cal.getTimeInMillis());
	    
	    ReqNoticeSaveDTO dto = ReqNoticeSaveDTO.builder()
				.title("제목제목제목제목제목제목제목")
				.contents("내용내용내용내용내용내용내용내용내용")
				.beginAt("2022-11-11 11:11:11")
				.expireAt("2022-11-11 11:11:11")
				.build();
        Gson gson = new Gson();
        String content = gson.toJson(dto);
        
		this.mockMvc.perform(post("/api/notice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(document("save-notice"));
	}
}