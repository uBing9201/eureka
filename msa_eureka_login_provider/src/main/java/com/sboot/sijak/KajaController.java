package com.sboot.sijak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sboot.sijak.vo.LoginVO;

//@Controller: 평상시 사용 컨트롤러 url 전달
//@RestController: data 전달 로그인 프로젝트에서 id pw 생성 후 msa 방식으로 사원 관리 프로젝트로 전송
// 혹은 사원관리 프로젝트에서 로그인 프로젝트의 id pw를 가져올때 사용

@Controller
public class KajaController {

	@Autowired
	private RestTemplate restTemplate;
	//spring3 이상 호출시 response 받을떄까지 기다리는 동기 방식
	
	@RequestMapping("/loginvo")
	public LoginVO getLogin() {
		LoginVO lvo = new LoginVO();
		
		lvo.setId("babo");
		lvo.setPw("ondal");
		
		return lvo;
	}
	
	@RequestMapping("/")
	public String kaja() {
		return "redirect:getallinfo";
	}
	
	@RequestMapping("getallinfo")
	public String login() {
		return "kaja/userLogin";
	}
	
	@RequestMapping("/toResult")
	public String loginKajaMain() {
		return "result";
	}
}
