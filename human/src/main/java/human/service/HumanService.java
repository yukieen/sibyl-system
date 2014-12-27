package human.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class HumanService {
    private final CounterService counterService;
    private static final String metricsName= "human.phychopass.crimecoefficient";

    @Autowired
    public HumanService(CounterService counterService) {
        this.counterService = counterService;
    }

    public void praise(int count) {
    	IntStream.range(0, count).forEach(it -> this.counterService.increment(metricsName));
    }
    
    public void abuse(int count){
    	IntStream.range(0, count).forEach(it -> this.counterService.decrement(metricsName));
    }
}
