package com.example.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SaveRecord;
import com.example.repository.SaveRecordRepo;

@RestController
public class MyController {

	@Autowired
	SaveRecordRepo repo;
	
	
	@GetMapping("/")
	public String getRequest(@RequestParam (value="text" ,required = false)String text )	        
	{
		SaveRecord saveRecord = new SaveRecord();
		String responseString = "Hello"+" "+getCurrentFormattedDateTime();
		if(text!=null)
		{
			responseString+=" "+text;
		}
		
		saveRecord.setDate(LocalDate.now());
		saveRecord.setQueryParam(text);
		repo.save(saveRecord);
		return responseString;
	}
	
	private String getCurrentFormattedDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return dateFormat.format(Calendar.getInstance().getTime()); 
	}
	@GetMapping("/alltransaction")
	public List<SaveRecord> getAllTransaction(){
		
		List<SaveRecord> saveRecordList=repo.findAll();
		return saveRecordList;
	}
	
	
	
}
