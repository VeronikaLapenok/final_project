package by.epam.lapenok.controller.command.impl;

import by.epam.lapenok.controller.command.Command;
import by.epam.lapenok.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.MAIN;
        return page;
    }
}
