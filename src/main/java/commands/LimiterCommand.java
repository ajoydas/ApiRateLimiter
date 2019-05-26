package commands;

import models.Api;
import storage.ApiStorage;
import utils.Logger;

public class LimiterCommand implements Command {
    public static class Args {
        public String apiName;
        public long limit;
    }

    public Args args;

    public LimiterCommand(Args args) {
        this.args = args;
    }

    @Override
    public void validateArgs() {

    }

    @Override
    public void execute() {
        Api api = ApiStorage.getStorage().getApiByName(args.apiName);
        api.setLimit(args.limit);
        Logger.log("Limit set to: "+args.limit);
    }
}
