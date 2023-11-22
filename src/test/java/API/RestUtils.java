package API;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName() {
		String generatedString =RandomStringUtils.randomAlphabetic(1);
		return("new"+generatedString);
	}

	public static String getCountry() {
		String generatedString =RandomStringUtils.randomAlphabetic(1);
		return("new"+generatedString);
	}
}
