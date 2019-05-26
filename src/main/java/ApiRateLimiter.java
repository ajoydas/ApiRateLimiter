import commands.Command;
import commands.CommandManager;
import exceptions.InvalidCommandException;
import exceptions.NotAllowedException;
import services.ServiceManager;
import storage.ApiStorage;
import utils.Logger;

import java.util.Scanner;

public class ApiRateLimiter {
    public static void main(String[] args) {
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.startAll();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String cmdString = scanner.nextLine();
            Command command = null;
            try {
                command = CommandManager.getCommand(cmdString);
                command.execute();
                ApiStorage.getStorage().printApis();

            } catch (InvalidCommandException e) {
                Logger.log("Invalid Command: " + e.getMessage());
            } catch (NotAllowedException e) {
                Logger.log("Not allowed command: "+e.getMessage());
            } catch (Exception e){
                Logger.log(String.valueOf(e.getStackTrace()));
            }
        }
//        serviceManager.stopAll();
    }
}
