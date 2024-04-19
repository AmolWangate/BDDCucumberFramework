package com.test.owner;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/envconfig.properties")
public interface EnvConfig extends Config {

	String browser();
	String url();
	String mode();
}
