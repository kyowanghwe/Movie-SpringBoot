package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	public static String drive ="F:/";
	public static String folderName = "Study";
	public static String folderPath = drive + folderName;
	
	@Autowired
	private MovieController movieController;
	
	@GetMapping("/")
	public String home(Model model) {
		String pathAcctress = "";
		String movieName = "";
		String actress = "";
		
		String srcMovie = "ext/" + pathAcctress + "/" + movieName +".mp4";
		String srcSubtitle = "ext/" + pathAcctress + "/" + movieName +".vtt";
		
		model.addAttribute("movieName", movieName);
		model.addAttribute("srcMovie", srcMovie);
		model.addAttribute("srcSubtitle", srcSubtitle);
		
		List<String> listMovie = movieController.getMp4FileName(folderPath+"/"+actress);
		List<String> actresses = movieController.getAllSubFolderName(folderPath);
		
		model.addAttribute("listMovie", listMovie);
		model.addAttribute("actresses", actresses);
		
		return "home";
	}
		
	@PostMapping("/movie")
	public String submit(Model model, 
						@RequestParam(name = "movieName") String movieName, 
						@RequestParam(name = "actress") String actress,
						@RequestParam(name = "currentDate") String currentDate,
						@RequestParam(name = "clientIP") String clientIP,
						@RequestParam(name = "clientCountry") String clientCountry,
						@RequestParam(name = "clientCity") String clientCity) {
		String pathAcctress = folderName +"/"+ actress;	
		String srcMovie = "ext/" + pathAcctress + "/" + movieName +".mp4";
		String srcSubtitle = "ext/" + pathAcctress + "/" + movieName +".vtt";
		
		model.addAttribute("movieName", movieName);
		model.addAttribute("srcMovie", srcMovie);
		model.addAttribute("srcSubtitle", srcSubtitle);
		
		List<String> listMovie = movieController.getMp4FileName(folderPath+"/"+actress);
		List<String> actresses = movieController.getAllSubFolderName(folderPath);
		
		model.addAttribute("listMovie", listMovie);
		model.addAttribute("actresses", actresses);
		
		if(!movieName.isEmpty()) {
			System.out.println("\033[0;32m"+currentDate +"  "+ clientIP +"  "+ clientCity +"  "+ clientCountry);
			System.out.println("\t \033[0m" + srcMovie);
		}
		
		return "home";
	}
	
//	@GetMapping("/")
//	public String home(Model model) {
//		String movieName = "";
//		
//		String srcMovie = "ext/" + folderName +"/"+ movieName + "/"+ movieName + ".mp4";
//		String srcSubtitle = "ext/" + folderName +"/"+ movieName + "/"+ movieName + ".vtt";
//		
//		
//		model.addAttribute("movieName", movieName);
//		model.addAttribute("srcMovie", srcMovie);
//		model.addAttribute("srcSubtitle", srcSubtitle);
//		
//		List<String> listMovie = movieController.getAllSubFolderName(folderPath);
//		model.addAttribute("listMovie", listMovie);
//		
//		return "home2";
//	}
//	
//	@PostMapping("/movie")
//	public String submit(Model model, 
//						@RequestParam(name = "movieName") String movieName, 
//						@RequestParam(name = "currentDate") String currentDate,
//						@RequestParam(name = "clientIP") String clientIP,
//						@RequestParam(name = "clientCountry") String clientCountry,
//						@RequestParam(name = "clientCity") String clientCity) {
//
//		String srcMovie = "ext/" +folderName +"/"+ movieName + "/"+ movieName + ".mp4";
//		String srcSubtitle = "ext/" +folderName +"/"+ movieName + "/"+ movieName + ".vtt";
//		
//		model.addAttribute("movieName", movieName);
//		model.addAttribute("srcMovie", srcMovie);
//		model.addAttribute("srcSubtitle", srcSubtitle);
//		
//		List<String> listMovie = movieController.getAllSubFolderName(folderPath);
//		model.addAttribute("listMovie", listMovie);
//		
//		if(!movieName.isEmpty()) {
//			System.out.println("\033[0;32m"+currentDate +"  "+ clientIP +"  "+ clientCity +"  "+ clientCountry);
//			System.out.println("\t \033[0m" + srcMovie);
//		}
//		
//		return "home2";
//	}
	
}
