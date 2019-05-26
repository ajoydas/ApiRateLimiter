package commands;

import exceptions.InvalidCommandException;

public class CommandManager {
    public static Command getCommand(String cmdString) throws InvalidCommandException {
        Command command = null;
        String[] commands = cmdString.split(" ");
        switch (commands[0]){
            case "Create":
                if(commands.length !=3 ){
                    throw new InvalidCommandException("Provide valid # of args");
                }
                CreateCommand.Args args = new CreateCommand.Args();
                args.apiName = commands[1];
                args.apiUrl = commands[2];
                command = new CreateCommand(args);
                break;
            case "Limit":
                if(commands.length !=3 ){
                    throw new InvalidCommandException("Provide valid # of args");
                }
                LimiterCommand.Args argsL = new LimiterCommand.Args();
                argsL.apiName = commands[1];
                argsL.limit = Long.parseLong(commands[2]);
                command = new LimiterCommand(argsL);
                break;
            case "LimitUsr":
                if(commands.length !=4 ){
                    throw new InvalidCommandException("Provide valid # of args");
                }
                LimitUserCommand.Args argsLU = new LimitUserCommand.Args();
                argsLU.userName = commands[1];
                argsLU.apiName = commands[2];
                argsLU.limit = Long.parseLong(commands[3]);
                command = new LimitUserCommand(argsLU);
                break;
            case "Call":
                if(commands.length !=2 ){
                    throw new InvalidCommandException("Provide valid # of args");
                }
                CallCommand.Args argsCall = new CallCommand.Args();
                argsCall.apiUrl = commands[1];
                command = new CallCommand(argsCall);
                break;
            case "CallUser":
                if(commands.length !=3 ){
                    throw new InvalidCommandException("Provide valid # of args");
                }
                CallUserCommand.Args argsCallUser = new CallUserCommand.Args();
                argsCallUser.apiName = commands[1];
                argsCallUser.userName = commands[2];

                command = new CallUserCommand(argsCallUser);
                break;
            default:
                throw new InvalidCommandException("Command not recognized.");
        }

        command.validateArgs();
        return command;
    }
}
