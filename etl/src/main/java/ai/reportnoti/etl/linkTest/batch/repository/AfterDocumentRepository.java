package ai.reportnoti.etl.linkTest.batch.repository;

import ai.reportnoti.etl.linkTest.batch.document.AfterDocument;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AfterDocumentRepository extends MongoRepository<AfterDocument, Integer> {

}
