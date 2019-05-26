package services;

public class ServiceManager {
    RefreshApiService apiService;
    public ServiceManager(){
        apiService = new RefreshApiService();
    }

    public void startAll(){
        apiService.start();
    }

    public void stopAll(){
        apiService.stop();
    }

}
