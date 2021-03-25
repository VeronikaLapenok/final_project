package by.epam.lapenok.controller.command;

import by.epam.lapenok.controller.command.impl.*;

public enum CommandName {
    SHOW_ALL_USERS {
        {
            this.command = new ShowAllUsersCommand();
        }
    },
    FIND_USER_BY_SURNAME {
        {
            this.command = new FindUserBySurnameCommand();
        }
    },
    SORT_USERS_BY_ID {
        {
            //this.command = new SortUsersByIdCommand();
        }
    },
    LOG_IN {
        {
            this.command = new LogInCommand();
        }
    },
    LOG_OUT {
        {
            //this.command = new LogOutCommand();
        }
    },
    EMPTY_COMMAND {
        {
            this.command = new EmptyCommand();
        }
    };

    Command command;
    public Command getCommand() {
        return  command;
    }
}
