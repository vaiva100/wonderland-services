package com.wonderland.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wonderland.model.PupilInformation;
import com.wonderland.reply.CreatePupilReply;
import com.wonderland.reply.GetAllPupilsReply;
import com.wonderland.reply.GetPupilByIdReply;
import com.wonderland.repository.PupilRepository;
import com.wonderland.request.CreatePupilRequest;
import com.wonderland.request.UpdatePupilRequest;


@Controller
public class PupilController {

	@Autowired
	private PupilRepository pupilRepository;
	
	
	@RequestMapping(method = RequestMethod.POST, value="/api/pupil")
	  @ResponseBody
	  public CreatePupilReply create(@RequestBody CreatePupilRequest request) {
		CreatePupilReply reply = new CreatePupilReply();
		try {
		  System.out.println("Starting Add Pupil");
		  PupilInformation pupilInformation = new PupilInformation();
		  pupilInformation.setName(request.getName());
		  pupilInformation.setSurname(request.getSurname());
		  pupilInformation.setAge(request.getAge());
		  
		  PupilInformation pupilInformationSaved = pupilRepository.save(pupilInformation);
		  reply.setSuccess(true);
		  reply.setPupilInformation(pupilInformationSaved);
		  System.out.println("Ending Add Pupil");
		}catch (Exception e) {
			 reply.setSuccess(false);
			 reply.setError(e.getMessage());
			 e.printStackTrace();
		}
		  
	      return reply;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/api/pupil")
	  @ResponseBody
	  public GetAllPupilsReply getAllPupils() {
		
		GetAllPupilsReply reply = new GetAllPupilsReply();
		try {
			System.out.println("Starting Get All Pupil");
			List<PupilInformation> list = pupilRepository.findAll();
			reply.setPupils(list);
			reply.setSuccess(true);
			System.out.println("Ending Get All Pupil");
		} catch (Exception e) {
			 reply.setSuccess(false);
			 reply.setError(e.getMessage());
			 e.printStackTrace();
		}
	      return reply;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/api/pupil/{pupilId}")
	  @ResponseBody
	  public GetPupilByIdReply getPupilById(@PathVariable("pupilId") Long pupilId) {
		GetPupilByIdReply reply = new GetPupilByIdReply();
		try {
			System.out.println("Starting Get All Pupil");
			Optional<PupilInformation> pupilOptional = pupilRepository.findById(pupilId);
			if(pupilOptional.isPresent()) {
				reply.setPupil(pupilOptional.get());
				reply.setSuccess(true);
			}else {
				throw new Exception("Pupil Not Found");
			}
			System.out.println("Ending Get All Pupil");
		} catch (Exception e) {
			 reply.setSuccess(false);
			 reply.setError(e.getMessage());
			 e.printStackTrace();
		}
	      return reply;
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value="/api/pupil/{pupilId}")
	  @ResponseBody
	  public CreatePupilReply update(@PathVariable("pupilId") Long pupilId,@RequestBody UpdatePupilRequest request) {
		  System.out.println("In registerStudent");
		  CreatePupilReply reply = new CreatePupilReply();
		  reply.setSuccess(true);
	      return reply;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/api/pupil")
	  @ResponseBody
	  public CreatePupilReply delete() {
		  System.out.println("In registerStudent");
		  CreatePupilReply reply = new CreatePupilReply();
		  reply.setSuccess(true);
	      return reply;
	}
}
