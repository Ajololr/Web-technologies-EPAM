package by.androsov.periodicals.controller.command.impl;

import by.androsov.periodicals.controller.command.Command;
import by.androsov.periodicals.service.ClientService;
import by.androsov.periodicals.service.exception.ServiceException;
import by.androsov.periodicals.service.factory.ServiceFactory;

public class SingIn implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = null;
        // get parameters from request and initialize the variables login and password
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            clientService.singIn(login, password);
            response = "Welcome";
        } catch (ServiceException e) {
            // write log
            response = "Error duiring login procedure";
        }
        return response;
    }
}
