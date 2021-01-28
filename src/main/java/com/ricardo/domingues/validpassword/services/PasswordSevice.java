package com.ricardo.domingues.validpassword.services;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.stereotype.Service;

import com.ricardo.domingues.validpassword.dto.PasswordDTO;

@Service
public class PasswordSevice {

	public boolean valid(PasswordDTO dto) {
		
		PasswordValidator validator = new PasswordValidator(				 
				  new LengthRule(8, 16),
				  new CharacterRule(EnglishCharacterData.UpperCase, 1),
				  new CharacterRule(EnglishCharacterData.LowerCase, 1),
				  new CharacterRule(EnglishCharacterData.Digit, 1),
				  new CharacterRule(EnglishCharacterData.Special, 1),
				  new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
				  new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
				  new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
				  new WhitespaceRule());

				final String password = dto.getText();
				RuleResult result = validator.validate(new PasswordData(password));
				if (result.isValid()) {
					return true;
				} else {
					return false;
				}
	}
}
