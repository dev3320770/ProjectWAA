package com.mum.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.Principal;
import java.nio.file.Files;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.model.Location;
import com.mum.model.Session;
import com.mum.model.SessionTransaction;
import com.mum.model.Student;
import com.mum.model.User;
import com.mum.service.LocationService;
import com.mum.service.SessionService;
import com.mum.service.SessionTransactionService;
import com.mum.service.StudentService;
import com.mum.service.UserService;
import com.mum.storage.StorageService;


@Controller
public class FileUploadController {
	@Autowired
	private SessionService sessionService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SessionTransactionService sessionTransactionRepository;
	@Autowired
	 private final StorageService storageService;
	@Autowired
	UserService userService; 
	
	
	 
	 @Autowired
	    public FileUploadController(StorageService storageService) {
	        this.storageService = storageService;
	    }
	
	    @RequestMapping(value="/upload" , method=RequestMethod.GET)
	    public String listUploadedFiles(Principal principal, Model model) throws IOException {	 
	    	User user = userService.findUserByUsername(principal.getName());
			System.out.println(user.getFirstName());
			model.addAttribute("user" , user);
	    	
//	    	   model.addAttribute("files", storageService.loadAll().map(
//	                   path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//	                           "serveFile", path.getFileName().toString()).build().toString())
//	                   .collect(Collectors.toList()));

	        return "admin/uploadFile";
	    }
	    
	    @PostMapping("/upload")
	    public String handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws IOException {

	    	String fileName=file.getOriginalFilename();
	    	
	        storageService.store(file);
	        redirectAttributes.addFlashAttribute("message","You successfully uploaded " + fileName + "!");
	        
	        Path filepath = storageService.load(fileName);
	        String ss=filepath.toString();
	        
	        String dataManual="manual";
	        String dataAuto="auto";
	        String dataType="";
	        
	        try (Scanner scanner = new Scanner(new File(ss))) {
				while (scanner.hasNext()){
					
					String line=scanner.nextLine();
					List<String> columns = Arrays.asList(line.split(","));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
					
					try {
						LocalDate dt =LocalDate.parse(columns.get(0),formatter);
						dataType=dataManual;
					}
					catch(DateTimeException ex) {
						dataType=dataAuto;
					}
					
					
					if(dataType==dataAuto)
					{
					String studentId= "98" + columns.get(0);
					//LocalDate localDate = LocalDate.parse(date, formatter);
					
					LocalDate date=LocalDate.parse(columns.get(1),formatter);
					String amPM=columns.get(2);
					String loc=columns.get(3);					
					
					List<Session> li=sessionService.findSessionBySessionDate(date);
					if(li.size()!=0)
					{
						Session session = sessionService.findSessionBySessionDate(date).get(0);
						System.out.println("Session: " + session);
						Student student = studentService.findByStudentId(studentId);
						System.out.println("Student: " + student);
						Location location = locationService.findByName(loc).get(0);
						System.out.println("Location: " + location);
						
						if (session != null && student != null && location != null) {
							SessionTransaction st=new SessionTransaction();
							st.setSession(session);
							st.setCheckinDate(date);					
							st.setLocation(location);
							st.setStudent(student);
							sessionTransactionRepository.save(st);
						}
					}
					}
				
					
					
					if(dataType==dataManual)
					{
						LocalDate date=LocalDate.parse(columns.get(0),formatter);
						String studentId=columns.get(1).replace("-","");	
						
						long stuL=Long.parseLong(studentId);
						studentId=Long.toString(stuL);
					
					List<Session> li=sessionService.findSessionBySessionDate(date);
					if(li.size()!=0)
					{
						Session session = sessionService.findSessionBySessionDate(date).get(0);
						System.out.println("Session: " + session);
						Student student = studentService.findByStudentId(studentId);
						System.out.println("Student: " + student);
						
						Location l1=new Location();
						l1.setId(1);
						l1.setName("DB");						
						
						if (session != null && student != null && l1 != null) {
							SessionTransaction st=new SessionTransaction();
							st.setSession(session);
							st.setCheckinDate(date);					
							st.setLocation(l1);
							st.setStudent(student);
							sessionTransactionRepository.save(st);
						}
					}
					}
					
					
					
				}
	        }

			catch (IOException e) {
				e.printStackTrace();
			}	     
	        
	        return "redirect:/upload";
	    }

}
