package problem2;

import org.apache.log4j.Logger;
import org.junit.Assert;

// Helper class to spawn threads
class PublishEventAndValidateTask implements Runnable{
    private static Logger logger =  Logger.getLogger(PublishEventAndValidateTask.class);
    private int numberOfIterationsInThread;
    private Statistic statistic;
    PublishEventAndValidateTask(Statistic statistic, int numberOfIterationsInThread){
        this.statistic = statistic;
        this.numberOfIterationsInThread = numberOfIterationsInThread;
    }
    @Override
    public void run() {
        for(int i=0;i<this.numberOfIterationsInThread;i++){
            statistic.event(1);
            long startTime = System.nanoTime();
            Assert.assertTrue(statistic.maximum() == 1);
            Assert.assertTrue(statistic.minimum() == 1);
            Assert.assertTrue(statistic.mean() == 1.0);
            Assert.assertTrue(statistic.variance() == 0);
            long endTime = System.nanoTime();
            logger.info("time taken for loop number = "+i +" is = "+ (endTime -startTime));
        }
        logger.info("all loop finished");
    }
}