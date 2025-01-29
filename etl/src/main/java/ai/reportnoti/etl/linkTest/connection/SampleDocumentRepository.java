package ai.reportnoti.etl.linkTest.connection;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleDocumentRepository extends MongoRepository<SampleDocument, String> {
}
