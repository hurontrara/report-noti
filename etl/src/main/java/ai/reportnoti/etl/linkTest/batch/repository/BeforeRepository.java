package ai.reportnoti.etl.linkTest.batch.repository;

import ai.reportnoti.etl.linkTest.batch.entity.BeforeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeforeRepository extends JpaRepository<BeforeEntity, Long> {

}
