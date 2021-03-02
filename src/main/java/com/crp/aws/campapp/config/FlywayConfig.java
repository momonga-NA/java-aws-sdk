package com.crp.aws.campapp.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 	Flywayの設定クラス
 *
 * @author ytkng
 *
 */
@Configuration
public class FlywayConfig {

	@Bean
	public FlywayMigrationStrategy strategy() {
		return flyway -> {
			flyway.clean();
			flyway.migrate();
		};
	}

}
