package pl.adcom.jte_template_example;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class JteTemplateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JteTemplateExampleApplication.class, args);
	}

	@Bean
	public DistributionSummary taskDistributionSummary(MeterRegistry registry) {
		return DistributionSummary.builder("task.distribution.summary")
				.description("Task distribution summary")
				.register(registry);
	}

	@Bean
	public Counter visitCounter(MeterRegistry registry) {
		return Counter.builder("visit_counter")
				.tags("counter-tag", "visitors")
				.description("Counts number of visits to the API")
				.register(registry);
	}
}
