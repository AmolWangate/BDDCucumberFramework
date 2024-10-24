package com.test.utils;

import java.util.Objects;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.customexceptions.InvalidKeyException;
import com.test.enums.Env;

public final class PropertyReader {
	
	private static final Logger LOG=LogManager.getLogger();
	
	private PropertyReader() {
	}

	public static String getPropertyValue(String filePath, Env key) {
		Properties properties = PropertyUtil.loadProperty(filePath);
		if (Objects.isNull(key) || Objects.isNull(properties.get(key.name().toLowerCase()))) {
			LOG.fatal("Incorrect key");
			throw new InvalidKeyException(String.format("Provided key %s is not correct", key));
		}
		return properties.getProperty(key.name().toLowerCase());
	}

}
