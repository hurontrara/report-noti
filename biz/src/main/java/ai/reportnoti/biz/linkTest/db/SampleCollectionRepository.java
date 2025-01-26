package ai.reportnoti.biz.linkTest.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleCollectionRepository extends MongoRepository<SampleCollection, String> {
}
