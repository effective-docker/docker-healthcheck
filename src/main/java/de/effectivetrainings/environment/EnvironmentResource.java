package de.effectivetrainings.environment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class EnvironmentResource {

    private StaticHealthIndicator staticHealthIndicator;

    public EnvironmentResource(StaticHealthIndicator staticHealthIndicator) {
        this.staticHealthIndicator = Objects.requireNonNull(staticHealthIndicator);
    }

    @RequestMapping("/environment/health")
    public void updateHealthStatus(@RequestParam(name = "status") boolean status) {
        this.staticHealthIndicator.setHealthy(status);
    }
}
