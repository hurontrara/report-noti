package ai.reportnoti.etl.linkTest.batch.repository;

import ai.reportnoti.etl.linkTest.batch.entity.AfterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfterRepository extends JpaRepository<AfterEntity, Long> {

}
