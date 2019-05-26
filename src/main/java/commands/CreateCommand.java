package commands;

import models.Api;
import storage.ApiStorage;
import utils.Logger;

public class CreateCommand implements Command {
    public static class Args {
        public String apiName;
        public String apiUrl;
    }

    public Args args;

    public CreateCommand(Args args) {
        this.args = args;
    }

    @Override
    public void validateArgs() {

    }

    @Override
    public void execute() {
        Api api = new Api(args.apiName, args.apiUrl);
        ApiStorage.getStorage().storeApi(args.apiName, args.apiUrl, api);
        Logger.log("Api: "+args.apiName+" created.");
    }
}
