package storage;

import models.Api;
import models.User;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class ApiStorage {
    HashMap<String, Api> apiMap;
    HashMap<String, String> urlToNameMap;
    HashMap<String, User> userMap;
    private static ApiStorage apiStorage = null;

    private ApiStorage() {
        apiMap = new HashMap<>();
        urlToNameMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public static ApiStorage getStorage() {
        if (apiStorage == null) {
            apiStorage = new ApiStorage();
        }
        return apiStorage;
    }

    public void storeApi(String apiName, String apiUrl, Api api) {
        this.apiMap.put(apiName, api);
        this.urlToNameMap.put(apiUrl, apiName);
    }

    public Api getApiByName(String apiName) {
        return this.apiMap.get(apiName);
    }

    public Api getApiByUrl(String apiUrl) {
        String apiName = this.urlToNameMap.get(apiUrl);
        return this.apiMap.get(apiName);
    }

    public void printApis() {
        Logger.log("<------------Current TestStorage---------->");
        for (Map.Entry<String, Api> stringTestEntry : apiMap.entrySet()) {
            Map.Entry pair = (Map.Entry) stringTestEntry;
            Logger.log(pair.getKey() + " = " + pair.getValue());
        }
    }


    public void runResetJob() {
//        Logger.log("Resetting api map.");
        for (Map.Entry<String, Api> stringTestEntry : apiMap.entrySet()) {
            Map.Entry pair = (Map.Entry) stringTestEntry;
            Api api = (Api) pair.getValue();
            api.setTotalCalled(0);
        }
    }

    public void storeUser(String userName, User user){
        userMap.put(userName, user);
    }

    public User getUser(String userName){
        return userMap.get(userName);
    }
}
