package ai.reportnoti.etl.linkTest.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LinkTestController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the ETL service.";
    }

}