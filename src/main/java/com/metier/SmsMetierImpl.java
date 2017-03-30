package com.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import com.dao.SmsRepository;
import com.entities.Sms;
@Service
public class SmsMetierImpl implements SmsMetier{

	@Autowired
	private SmsRepository smsRepository;
	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> listSms() {
		
		return smsRepository.findAll();
	}
	@Override
	public List<Sms> findNoActiveSms() {
		return smsRepository.findNoActiveSms();
	}
	/*@Override
	public void updateSmsState() {
		smsRepository.updateSmsState();	
	}
    public Sms firstSms(Long Id) {
		return smsRepository.firstSms(Id);
	}
	
	@Override
	public void updateSmsState(Long id) {
		smsRepository.updateSmsState(id);
		}*/
}
