package com.sboot.sijak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.sijak.vo.LoginVO;

@RestController
public class kajaController2 {

	@GetMapping("/loginvo")
	public LoginVO getLogin() {
		LoginVO lvo = new LoginVO();
		
		lvo.setId("babo");
		lvo.setPw("ondal");
		
		return lvo;
	}
}
