package com.codecolonist.credentialsservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codecolonist.credentialsservice.Repository.CredRepository;
import com.codecolonist.credentialsservice.Repository.Credentials;


@RestController
public class credentialcontroller {
	
	@Autowired
	private CredRepository credrrepo;
	
	@RequestMapping(value="/addcred",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Credentials> AddCredentials(@RequestBody Credentials credentials,HttpServletRequest servletRequest) throws Exception  {
		
		credrrepo.save(credentials);
	
		return new ResponseEntity<>(credentials,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/allcred")
	public  ResponseEntity<List<Credentials>> getCredentials() throws Exception  {
		
		List<Credentials> credentialsList = new ArrayList<Credentials>();
		
		credentialsList=credrrepo.findAll();
	
		return new ResponseEntity<>(credentialsList,HttpStatus.ACCEPTED);
		
	}

}
