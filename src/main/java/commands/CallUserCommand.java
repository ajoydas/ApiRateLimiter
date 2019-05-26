package commands;

import exceptions.NotAllowedException;
import models.Api;
import models.User;
import storage.ApiStorage;
import utils.Logger;

public class CallUserCommand implements Command {
    public static class Args {
        public String apiName;
        public String userName;
    }

    public Args args;

    public CallUserCommand(Args args) {
        this.args = args;
    }

    @Override
    public void validateArgs() {

    }

    @Override
    public void execute() throws NotAllowedException {
//        Api api = ApiStorage.getStorage().getApiByUrl(args.apiUrl);
        User user = ApiStorage.getStorage().getUser(args.userName);
        Long called = user.getApiCalled(args.apiName);
        if(user.getApiLimit(args.apiName) >= called){
            throw new NotAllowedException("Limit crossed. Access Restricted.");
        }
        user.setApiCalled(args.apiName, called+1);
        Logger.log("Api called.");
    }
}
