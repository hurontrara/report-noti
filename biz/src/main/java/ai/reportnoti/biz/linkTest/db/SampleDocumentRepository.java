package ai.reportnoti.biz.linkTest.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleDocumentRepository extends MongoRepository<SampleDocument, String> {
}
