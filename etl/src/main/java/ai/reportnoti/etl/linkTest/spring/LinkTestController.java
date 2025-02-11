package ai.reportnoti.etl.linkTest.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LinkTestController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the ETL service.";
    }

    @GetMapping("/log")
    public String log() {
        log.trace("TRACE!!");
        log.debug("DEBUG!!");
        log.info("INFO!!");
        log.warn("WARN!!");
        log.error("ERROR!!");
        return "log test";
    }

}