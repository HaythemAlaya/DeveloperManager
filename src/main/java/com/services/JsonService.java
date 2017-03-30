package com.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.dao.FormRepository;
import com.entities.AngualrJson;
import com.entities.androidJson.AndroidComponent;
import com.entities.androidJson.AndroidForm;
import com.entities.androidJson.AndroidForm.Step;
import com.entities.androidJson.AndroidOption;
import com.entities.androidJson.AndroidValidator;

@RestController
@ApplicationScope
public class JsonService {

	private HashMap<String, String> angulatToAndroidComponent = new HashMap<>();
	@Autowired
	private  FormRepository formRepository;
	private AndroidForm androidForm ;
	@RequestMapping(value = "/convert", method = RequestMethod.GET)
	public AndroidForm getSms(@RequestBody List<AngualrJson> angularjs) {
		return angularToAndroidJson(angularjs);
	}

	@PostConstruct
	private void init() {
		angulatToAndroidComponent.clear();
		angulatToAndroidComponent.put("textInput", "edit_text");
		angulatToAndroidComponent.put("textArea", "edit_text");
		angulatToAndroidComponent.put("checkbox", "check_box");
		angulatToAndroidComponent.put("select", "spinner");
		angulatToAndroidComponent.put("radio", "radio");
		angulatToAndroidComponent.put("name", "none");

	}

	private AndroidForm angularToAndroidJson(List<AngualrJson> anjs) {
		List<AndroidComponent> result = new ArrayList<AndroidComponent>();
		anjs.forEach(input -> {
			AndroidComponent ajs = new AndroidComponent();
			ajs.setKey(input.getIndex() + ""); // TODO:KEY LOGIC
			ajs.setHint(input.getLabel());
			ajs.setLabel(input.getLabel());
			ajs.setType(angulatToAndroidComponent.get(input.getComponent()));
			if (input.getRequired())
				ajs.setV_required(new AndroidValidator("true", "Please enter some value this is a required field"));
			else
				ajs.setV_required(new AndroidValidator("fasle", ""));
			if (input.getValidation() != null) {
				if (input.getValidation().equalsIgnoreCase("email"))
					ajs.setV_email(new AndroidValidator("true", "Not an email."));
				else if (input.getValidation().equalsIgnoreCase("number"))
					ajs.setV_regex(new AndroidValidator("[0-9]+", "it is a number !"));
			}
			if (input.getOptions() != null && !input.getOptions().isEmpty()) {

				if (input.getComponent().equalsIgnoreCase("checkbox")
						|| input.getComponent().equalsIgnoreCase("radio")) {
					ajs.setOptions(new ArrayList<AndroidOption>());

					input.getOptions().forEach(option -> {
						ajs.getOptions().add(new AndroidOption("", option, "false"));
					});

				} else if (input.getComponent().equalsIgnoreCase("select")) {
					ajs.setValues(input.getOptions());
				}
			}
			result.add(ajs);
		});

		 androidForm = new AndroidForm();
		
		androidForm.getStep1().setFields(result);
		androidForm.getStep1().setTitle("form");
	
		return androidForm;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public AndroidForm find() {
		return androidForm;
	}
	

}
