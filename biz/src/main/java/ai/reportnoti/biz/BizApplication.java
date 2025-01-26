package ai.reportnoti.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BizApplication {

	public static void main(String[] args) {
		SpringApplication.run(BizApplication.class, args);
	}

}
