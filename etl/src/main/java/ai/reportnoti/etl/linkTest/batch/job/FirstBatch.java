package ai.reportnoti.etl.linkTest.batch.job;

import ai.reportnoti.etl.linkTest.batch.document.AfterDocument;
import ai.reportnoti.etl.linkTest.batch.document.BeforeDocument;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.MongoPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@Configuration
public class FirstBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final MongoTemplate mongoTemplate;

    public FirstBatch(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, MongoTemplate mongoTemplate) {
        this.jobRepository = jobRepository;
        this.platformTransactionManager = platformTransactionManager;
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public Job firstJob() {
        return new JobBuilder("firstJob", jobRepository)
                .start(firstStep())
                .build();
    }

    @Bean
    public Step firstStep() {
        return new StepBuilder("firstStep", jobRepository)
                .<BeforeDocument, AfterDocument>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .build();
    }

    @Bean
    public MongoPagingItemReader<BeforeDocument> beforeReader() {
        MongoPagingItemReader<BeforeDocument> reader = new MongoPagingItemReader<>();
        reader.setName("beforeReader");
        reader.setTemplate(mongoTemplate);
        reader.setTargetType(BeforeDocument.class);
        reader.setQuery(new BasicQuery("{}"));
        reader.setSort(new HashMap<>() {{
            put("_id", Sort.Direction.ASC);
        }});
        reader.setPageSize(10);
        return reader;
    }

    @Bean
    public ItemProcessor<BeforeDocument, AfterDocument> middleProcessor() {
        return item -> {
            AfterDocument afterDocument = new AfterDocument();
            afterDocument.setName(item.getName());
            return afterDocument;
        };
    }

    public MongoItemWriter<AfterDocument> afterWriter() {
        MongoItemWriter<AfterDocument> writer = new MongoItemWriter<>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("after_collection");
        return writer;
    }

}
