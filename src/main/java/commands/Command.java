package commands;

import exceptions.NotAllowedException;

public interface Command {
    public void validateArgs();
    public void execute() throws NotAllowedException;
}
