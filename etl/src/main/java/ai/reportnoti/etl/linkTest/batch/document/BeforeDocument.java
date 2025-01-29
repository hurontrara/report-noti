package ai.reportnoti.etl.linkTest.batch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "before_collection")
@Getter
@Setter
public class BeforeDocument {

    @Id
    private String id;

    private String name;

    @Field("email_address")
    private String email;

}
