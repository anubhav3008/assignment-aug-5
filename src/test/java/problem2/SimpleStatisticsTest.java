package problem2;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.*;

public class SimpleStatisticsTest {

    private static Logger logger =  Logger.getLogger(SimpleStatisticsTest.class);
    @Test
    public void publishEventAndValidate() throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        int loopIterations = 100;
        int concurrencyLevel = 100; // Change this value to set the concurrency level
        Statistic statistic = new SimpleStatistics(loopIterations * concurrencyLevel);


        // Create a thread pool with the desired concurrency level
        ExecutorService executorService = Executors.newFixedThreadPool(concurrencyLevel);

        // Submit tasks to the thread pool
        for (int i = 0; i < concurrencyLevel; i++) {
            executorService.submit(new PublishEventAndValidateTask(statistic,loopIterations));
        }

        // Shutdown the executor service after all tasks are complete
        executorService.shutdown();
        executorService.awaitTermination(50, TimeUnit.SECONDS);

        Field privateField = SimpleStatistics.class.getDeclaredField("numbers");
        privateField.setAccessible(true);
        BlockingQueue<Integer> values = (BlockingQueue<Integer>) privateField.get(statistic);
        logger.info("final count = "+ values.stream().count());
        Assert.assertTrue(values.stream().count() == loopIterations * concurrencyLevel);
    }
}
