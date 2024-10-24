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
	
	String browsername();
	String browserversion();
	String os();
	String username();
	String accesskey();
	String osversion();
	String consolelogs();
	String seleniumversion();
	String remoteurl();
}
