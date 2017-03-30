package com.metier;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.entities.Sms;

public interface SmsMetier {
	public List<Sms> listSms();
	public List<Sms> findNoActiveSms();
/*	public void updateSmsState();*/
	//public Sms firstSms(Long id);
	/*public Sms firstSms(Long Id);
	public void updateSmsState(Long id);*/

}
