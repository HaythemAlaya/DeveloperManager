package com.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.SmsRepository;
import com.entities.Sms;
import com.metier.SmsMetier;

@RestController
public class SmsRestService {
	@Autowired
public SmsMetier smsMetier;
	@Autowired
private SmsRepository smsRepository;

@RequestMapping(value="/smsnotsend",method=RequestMethod.GET)
public List<Sms> findNoActiveSms() {
		return smsMetier.findNoActiveSms();
	}
@RequestMapping(value="/sms",method=RequestMethod.GET)
	public List<Sms> listSms() {
		return smsMetier.listSms();
	}

@RequestMapping(value="/sms/{id}",method=RequestMethod.GET)
public Sms getSms(@PathVariable Long id) {
	return smsRepository.findOne(id);
}

@RequestMapping(value="/savesms",method=RequestMethod.POST)
public Sms save(@RequestParam String msg, @RequestParam String phone,@RequestParam String created_date, @RequestParam String owner, @RequestParam String car_number ) {
	Sms sms =new Sms();
	sms.setMsg(msg);
	sms.setPhone(phone);
	sms.setState(false);
	sms.setSend_date(null);
	sms.setCreated_date(created_date);
	sms.setOwner(owner);
	sms.setCar_number(car_number);
	return smsRepository.save(sms);
}

@RequestMapping(value="/sms/{id}",method=RequestMethod.PUT)
public Sms updateSmsState(@RequestBody Sms s,@PathVariable Long id) {
	s.setId(id);
	return smsRepository.saveAndFlush(s);
}
@RequestMapping(value="/smssave",method=RequestMethod.POST)
public Sms save(@RequestBody Sms s) {
	return smsRepository.save(s);
}

}
