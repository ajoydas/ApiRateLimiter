package models;

public class Api {
    private String apiName;
    private String apiUrl;
    private long limit;
    private long totalCalled;

    public Api(String apiName, String apiUrl) {
        this.apiName = apiName;
        this.apiUrl = apiUrl;
        this.limit = 0;
        this.totalCalled = 0;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getTotalCalled() {
        return totalCalled;
    }

    public void setTotalCalled(long totalCalled) {
        this.totalCalled = totalCalled;
    }

    @Override
    public String toString() {
        return "Api{" +
                "apiName='" + apiName + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", limit=" + limit +
                ", totalCalled=" + totalCalled +
                '}';
    }
}
