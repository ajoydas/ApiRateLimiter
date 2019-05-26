package commands;

import exceptions.NotAllowedException;
import models.Api;
import storage.ApiStorage;
import utils.Logger;

public class CallCommand implements Command {
    public static class Args {
        public String apiUrl;
    }

    public Args args;

    public CallCommand(Args args) {
        this.args = args;
    }

    @Override
    public void validateArgs() {

    }

    @Override
    public void execute() throws NotAllowedException {
        Api api = ApiStorage.getStorage().getApiByUrl(args.apiUrl);
        if(api.getTotalCalled() >= api.getLimit()){
            throw new NotAllowedException("Limit crossed. Access Restricted.");
        }
        api.setTotalCalled(api.getTotalCalled()+1);
        Logger.log("Api called.");
    }
}
