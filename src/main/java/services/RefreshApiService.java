package services;

import storage.ApiStorage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RefreshApiService implements Service {
    private ScheduledExecutorService executor;

    @Override
    public void start() {
        Runnable jobRunnable = new Runnable() {
            public void run() {
                ApiStorage.getStorage().runResetJob();
            }
        };

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(jobRunnable, 0, 60, TimeUnit.SECONDS);
    }

    @Override
    public void stop() {
        executor.shutdownNow();
    }
}
