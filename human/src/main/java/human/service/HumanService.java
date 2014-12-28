package human.service;

import java.util.stream.IntStream;

import human.model.Human;
import human.model.Psychopass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class HumanService {

    private final Human human = new Human("ほげくん",new Psychopass());

    @Autowired
    private CounterService counterService;

    private static final String METRICS = "human.psychopass.crimecoefficient";

    public Human getHuman() {
        return human;
    }

	public void increment(int count) {
        human.getPsychoPass().increment(count);
    	IntStream.range(0, count).forEach(it -> this.counterService.increment(METRICS));
    }
    
	public void decrement(int count){
        human.getPsychoPass().decrement(count);
    	IntStream.range(0, count).forEach(it -> this.counterService.decrement(METRICS));
    }

    public void paralize() {
        human.paralize();
    }
}
