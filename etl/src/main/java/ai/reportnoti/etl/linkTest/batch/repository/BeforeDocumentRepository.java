package ai.reportnoti.etl.linkTest.batch.repository;

import ai.reportnoti.etl.linkTest.batch.document.BeforeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeforeDocumentRepository extends MongoRepository<BeforeDocument, Integer> {

}
