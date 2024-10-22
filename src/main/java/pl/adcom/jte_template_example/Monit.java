package pl.adcom.jte_template_example;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Monit {

    private final Counter visitCounter;
    private final List<Integer> queues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    private final DistributionSummary taskDistributionSummary;
    private final Random random = new Random();
    private final MeterRegistry registry;

    public Monit(Counter visitCounter, DistributionSummary taskDistributionSummary, MeterRegistry registry) {
        this.visitCounter = visitCounter;
        this.taskDistributionSummary = taskDistributionSummary;
        this.registry = registry;

        visitCounter = Counter.builder("visit_counter")
                .tags("counter-tag", "visitors")
                .description("Time required for the api")
                .register(registry);


        Gauge.builder("queue_size", queues, queues -> queues.size())
                .register(registry);

        DistributionSummary.builder("http_request_histogram_example")
                .description("Histogram example")
                .publishPercentileHistogram()
                .register(registry);
    }

    @GetMapping("/visitApi")
    public String visitCounter() {
        visitCounter.increment();
        return "visitApi called: " + visitCounter.count();
    }

    @GetMapping("/getQueueSize")
    public String gaugeExample() {

        int number = random.nextInt(2000- 500) + 500;
        return "Gauge example api called: " + queues.size();
    }

    @GetMapping("/histogram")
    public String histogramExample() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread.sleep(random.nextInt(1000 - 10) + 10);

        long duration = System.currentTimeMillis() - startTime;

        return "histogram api called: " + duration;
    }

}
