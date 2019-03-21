package com.mum.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.storage.*;

import com.mum.controller.FileUploadController;
import com.mum.model.Location;
import com.mum.model.Session;
import com.mum.model.SessionTransaction;
import com.mum.service.LocationService;
import com.mum.service.SessionService;
import com.mum.service.SessionTransactionService;
import com.mum.service.StudentService;


@Controller
public class FileUploadController {
	@Autowired
	private SessionService sessionService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private StudentService studentRepository;
	@Autowired
	private SessionTransactionService sessionTransactionRepository;
	
	 private final StorageService storageService;
	 
	 
	 @Autowired
	    public FileUploadController(StorageService storageService) {
	        this.storageService = storageService;
	    }
	
	    @GetMapping("/upload")
	    public String listUploadedFiles(Model model) throws IOException {	 
	    	
//	    	   model.addAttribute("files", storageService.loadAll().map(
//	                   path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//	                           "serveFile", path.getFileName().toString()).build().toString())
//	                   .collect(Collectors.toList()));

	        return "/admin/uploadFile";
	    }
	    
	    @PostMapping("/upload")
	    public String handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws IOException {

	    	String fileName=file.getOriginalFilename();
	    	
	        storageService.store(file);
	        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + fileName + "!");
	        
	        Path filepath = storageService.load(fileName);
	        String ss=filepath.toString();
	        
	        try (Scanner scanner = new Scanner(new File(ss))) {
				while (scanner.hasNext()){
					
					String line=scanner.nextLine();
					List<String> columns = Arrays.asList(line.split(","));
					
					long studentId=Long.parseLong(columns.get(0));
					//LocalDate localDate = LocalDate.parse(date, formatter);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
					LocalDate date=LocalDate.parse(columns.get(1),formatter);
					String amPM=columns.get(2);
					String loc=columns.get(3);
					
					
					// get SessionID by Date
					Session session=sessionService.findSessionBySessionDate(date).get(0);
					
					SessionTransaction st=new SessionTransaction();
					st.setSession(session);
					st.setCheckinDate(date);					
					Location loc1=locationService.findByName(loc).get(0);
					st.setLocation(loc1);
					st.setStudent(studentRepository.findById(studentId));
					
					sessionTransactionRepository.save(st);
					
					System.out.println(scanner.nextLine());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        
	       // Resource res=     storageService.loadAsResource(fileName);
	        
	        return "redirect:/upload";
	    }

}
