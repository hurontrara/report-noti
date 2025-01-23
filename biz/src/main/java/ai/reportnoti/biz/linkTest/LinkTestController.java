package ai.reportnoti.biz.linkTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biz")
public class LinkTestController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Biz service.";
    }
}






