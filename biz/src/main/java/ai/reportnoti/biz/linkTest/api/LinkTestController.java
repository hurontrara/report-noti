package ai.reportnoti.biz.linkTest.api;

import ai.reportnoti.biz.linkTest.db.SampleDocument;
import ai.reportnoti.biz.linkTest.db.SampleDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biz/test")
@RequiredArgsConstructor
public class LinkTestController {

    private final MongoTemplate mongoTemplate;
    private final SampleDocumentRepository sampleDocumentRepository;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Biz service.";
    }

    // using mongoTemplate
    @PostMapping("/insert/template")
    public String insert() {

        SampleDocument sample = new SampleDocument();
        sample.setName("testMongoTemplateName");
        sample.setEmail("testMongoTemplateName@example.com");

        mongoTemplate.insert(sample);

        return "Inserted successfully";

    }

    // using mongoRepository
    @PostMapping("/insert/repository")
    public String insert2() {

        SampleDocument sample = new SampleDocument();
        sample.setName("testMongoRepositoryName");
        sample.setEmail("testMongoRepositoryName@example.com");

        sampleDocumentRepository.save(sample);

        return "Inserted successfully";

    }

}






