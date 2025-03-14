package data.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.SawonDto;
import data.service.SawonService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class SawonController {
	
	final SawonService sawonService;
	final NcpObjectStorageService storageService;
	
	private String imagePath="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/sawon/";
	private String bucketName="bitcamp-bucket-56";
	
	@GetMapping("/")
	public String mainPage()
	{
		return "sawon/mainpage";		
	}
	
	@GetMapping({"/list"})
	public String sawonList(Model model)
	{
		List<SawonDto> list=sawonService.getSelectAllSawon();
		model.addAttribute("list", list);
		model.addAttribute("totalCount", list.size());
		model.addAttribute("imagePath", imagePath);
		
		return "sawon/sawonlist";		
	}
	
	@GetMapping("/form")
	public String sawonForm()
	{
		return "sawon/sawonform";		
	}
	
	@PostMapping("/insert")
	public String sawonInsert(@ModelAttribute SawonDto dto,
			@RequestParam("upload") MultipartFile upload)
	{
		if(upload.getOriginalFilename().equals(""))
			dto.setPhoto(null);
		else {
			String photo=storageService.uploadFile(bucketName, "sawon", upload);
			dto.setPhoto(photo);
		}
		
		sawonService.insertSawon(dto);
		return "redirect:./list";
	}
}




















