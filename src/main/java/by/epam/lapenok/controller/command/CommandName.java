package by.epam.lapenok.controller.command;

import by.epam.lapenok.controller.command.impl.FindUserByNameCommand;
import by.epam.lapenok.controller.command.impl.FindUserBySurnameCommand;
import by.epam.lapenok.controller.command.impl.LogInCommand;
import by.epam.lapenok.controller.command.impl.LogOutCommand;
import by.epam.lapenok.controller.command.impl.SortUsersByIdCommand;
import by.epam.lapenok.controller.command.impl.ShowAllUsersCommand;

public enum CommandName {
    SHOW_ALL_USERS {
        {
            this.command = new ShowAllUsersCommand();
        }
    },
    FIND_USER_BY_NAME {
        {
            this.command = new FindUserByNameCommand();
        }
    },
    FIND_USER_BY_SURNAME {
        {
            this.command = new FindUserBySurnameCommand();
        }
    },
    SORT_USERS_BY_ID {
        {
            this.command = new SortUsersByIdCommand();
        }
    },
    LOG_IN {
        {
            this.command = new LogInCommand();
        }
    },
    LOG_OUT {
        {
            this.command = new LogOutCommand();
        }
    };

    Command command;
    public Command getCommand() {
        return  command;
    }
}
