package com.lombok.examples.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
// Generates: private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
// Other logging frameworks have their own annotations, e.g. @Log4j2, @CommonsLog, @Log (java.util.logging).
@Component
public class LogExample {

    public void example() {
        log.info("I'm logged at INFO level using the generated 'log' field!");
        log.debug("I'm logged at DEBUG level, so I'm not printed by default.");
        log.warn("I'm logged at WARN level with a parameter: {}", 42);
    }
}
