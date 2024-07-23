package org.gooddog.deadlockedthreadmetrics;

import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.core.instrument.binder.jvm.JvmThreadDeadlockMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricBinderConfiguration {
    @Bean
    public MeterBinder jvmThreadDeadlockMetricsBinder() {
        return new JvmThreadDeadlockMetrics();
    }
}
