package problem2;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// This is the simplest implementation of Statistics.
// insert : O(1)
// avg, max, min, variance = O(n)
// It will become slow over time.
public class SimpleStatistics implements Statistic{
    private static Logger logger =  Logger.getLogger(SimpleStatistics.class);
    private BlockingQueue<Integer> numbers;

    public SimpleStatistics(int maxSize){
        this.numbers = new ArrayBlockingQueue<>(maxSize, false);
    }

    @Override
    public void event(int value) {
        while (!this.numbers.add(value)){
            logger.error("unable to add value");
        }
    }

    @Override
    public float mean() {
        var mean = (float) this.numbers.stream().mapToInt(x -> x).average().getAsDouble();
        return mean;
    }

    @Override
    public int minimum() {
        var min = this.numbers.stream().mapToInt(x -> x).min().getAsInt();
        return min;
    }

    @Override
    public int maximum() {
        var max = this.numbers.stream().mapToInt(x -> x).max().getAsInt();
        return max;
    }

    @Override
    public float variance() {
        int sum = 0;
        float mean = this.mean();
        int count = (int) numbers.stream().count();
        logger.info("count = "+count);
        for(var number: numbers){
            sum += (number - mean) * (number - mean);
        }
        int variance = sum/count;
        return variance;
    }
}
