package storage;

import models.Api;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;

public class ApiStorage {
    HashMap<String, Api> apiMap;
    HashMap<String, String> urlToNameMap;
    private static ApiStorage apiStorage = null;

    private ApiStorage() {
        apiMap = new HashMap<>();
        urlToNameMap = new HashMap<>();
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
        Logger.log("Resetting api map.");
        for (Map.Entry<String, Api> stringTestEntry : apiMap.entrySet()) {
            Map.Entry pair = (Map.Entry) stringTestEntry;
            Api api = (Api) pair.getValue();
            api.setTotalCalled(0);
        }
    }
}
