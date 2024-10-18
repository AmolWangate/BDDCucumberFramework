package com.test.owner;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "file:${user.dir}/src/test/resources/config/envconfig.properties", 
    "file:${user.dir}/src/test/resources/config/remoteconfig.properties"
})
public interface EnvConfig extends Config {

	String browser();
	String url();
	String mode();
	
	String browserName();
	String browserVersion();
	String os();
	String userName();
	String accessKey();
	String osVersion();
	String consoleLogs();
	String seleniumVersion();
	String remoteURL();
}
