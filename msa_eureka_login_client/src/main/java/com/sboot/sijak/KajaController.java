package com.sboot.sijak;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sboot.sijak.dao.SawonDAO;
import com.sboot.sijak.vo.LoginVO;
import com.sboot.sijak.vo.SawonVO;

@Controller
public class KajaController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SawonDAO sDAO;
	
	@GetMapping("/")
	public String kaja(Model model1) {
		
		//해당 프로젝트에서 단순 객체만을 가져온다
		LoginVO lVO = restTemplate.getForObject("http://sawonlogin-service/loginvo", LoginVO.class);
		
		System.out.println(lVO.getId());
		System.out.println(lVO.getPw());
		
		return "redirect:getAllInfo";
	}
	
	//데이터연관 : RestTemplate, getForObject() ==> feign ==> webclient
	
	@GetMapping("/getAllInfo")
	public String getAllInfo(Model model) {
		List<SawonVO> sVO = sDAO.getAllInfo();
		model.addAttribute("sawonList", sVO);
		return "getAllInfo";
	}
	
	@RequestMapping("/getinfo")
    public String view(HttpServletRequest req1, Model model1) {
        String name = req1.getParameter("name");
        model1.addAttribute("vo", sDAO.getInfo(name));
        return "getinfo";
    }
    
    @RequestMapping("/insertForm")	//views에서 처리하므로 일단 컨트롤러로 왔다가 VIEWS로감
    public String insertForm() {	//거기서 입력받음 (원래는 출력모드)
        
        return "insertForm";
    }
    
    @RequestMapping("/updateinfo")
    public String updateinfo(HttpServletRequest req1,Model model1) {
            String name=req1.getParameter("name");
            String tel=req1.getParameter("tel");
            //System.out.println(name);
            sDAO.updateInfo(name,tel);
                     
        return "redirect:getAllInfo";
    }
   
    
    @RequestMapping("/insertinfo")
    public String insertinfo(HttpServletRequest req1,Model model1) {
            String name=req1.getParameter("name");
            String tel=req1.getParameter("tel");
            System.out.println(name);
            sDAO.insertInfo(name,tel);
                     
        return "redirect:getAllInfo";
    }
    
    @RequestMapping("/deleteinfo")
    public String delete(HttpServletRequest req1) {
            String name=req1.getParameter("name");
            sDAO.deleteInfo(name);
        return "redirect:getAllInfo";
    }
}
