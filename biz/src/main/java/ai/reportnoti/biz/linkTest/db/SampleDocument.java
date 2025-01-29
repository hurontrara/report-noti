package ai.reportnoti.biz.linkTest.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sample_collection")
@Getter
@Setter
public class SampleDocument {
    @Id
    private String id;

    private String name;

    @Field("email_address")
    private String email;

}
