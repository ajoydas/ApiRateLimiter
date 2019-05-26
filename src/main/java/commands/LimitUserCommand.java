package commands;

import models.Api;
import models.User;
import storage.ApiStorage;
import utils.Logger;

public class LimitUserCommand implements Command {
    public static class Args {
        public String userName;
        public String apiName;
        public long limit;
    }

    public Args args;

    public LimitUserCommand(Args args) {
        this.args = args;
    }

    @Override
    public void validateArgs() {

    }

    @Override
    public void execute() {
        User user = new User(args.userName);
        ApiStorage.getStorage().storeUser(args.userName, user);
        user.setApiLimit(args.apiName, args.limit);
        Logger.log("User limit set to: "+args.limit);
    }
}
