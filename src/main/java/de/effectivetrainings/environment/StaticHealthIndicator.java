package de.effectivetrainings.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class StaticHealthIndicator implements HealthIndicator {

    @Value("${environment.health.status:true}")
    private boolean healthy;

    @Override
    public Health health() {
        return healthy ? Health
                .up().build() : Health
                .down().build();
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
}
