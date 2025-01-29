package ai.reportnoti.etl.linkTest.connection;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etl")
@RequiredArgsConstructor
public class LinkTestController {

    private final MongoTemplate mongoTemplate;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the ETL service.";
    }

    @PostMapping("/insert/template")
    public String insert() {

        SampleDocument sample = new SampleDocument();
        sample.setName("testMongoTemplateName");
        sample.setEmail("testMongoTemplateName@example.com");

        mongoTemplate.insert(sample);

        return "Inserted successfully";

    }



}