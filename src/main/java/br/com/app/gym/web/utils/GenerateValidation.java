package br.com.app.gym.web.utils;

import java.util.Date;
import java.util.UUID;

public class GenerateValidation {
	public static String keyValidation() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase().replace('-', 'X')
				+ String.valueOf((new Date()).getTime());
	}
}