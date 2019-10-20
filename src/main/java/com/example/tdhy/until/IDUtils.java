package com.example.tdhy.until;

import java.util.UUID;

public class IDUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("", "");
	}
}
