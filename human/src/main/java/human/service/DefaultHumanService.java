package human.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class DefaultHumanService implements HumanService {
    private final CounterService counterService;
    private static final String metricsName= "human.psychopass.crimecoefficient";

    @Autowired
    public DefaultHumanService(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
	public void increment(int count) {
    	IntStream.range(0, count).forEach(it -> this.counterService.increment(metricsName));
    }
    
    @Override
	public void decrement(int count){
    	IntStream.range(0, count).forEach(it -> this.counterService.decrement(metricsName));
    }
}
