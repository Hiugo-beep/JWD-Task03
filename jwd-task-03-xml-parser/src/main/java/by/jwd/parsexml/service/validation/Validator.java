package by.jwd.parsexml.service.validation;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
	public static boolean fileNameValidator(String fileName) {
		boolean isValid = true;
		if(fileName == null) {
			isValid = false;
		}
		Pattern structureOfFileName = Pattern.compile("(resources/)([.[^\\/:\\*?<>\"\\+\\|]]+)\\.((xml)|(txt))"); //"resources/*******.xml(+/.txt)
		Matcher result = structureOfFileName.matcher(fileName);
		isValid = result.find();
		return isValid;
	}
}
