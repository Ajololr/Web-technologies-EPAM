package by.androsov.periodicals.service.factory;

import by.androsov.periodicals.service.ClientService;
import by.androsov.periodicals.service.PublicationService;
import by.androsov.periodicals.service.impl.ClientServiceImpl;
import by.androsov.periodicals.service.impl.PublicationServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final PublicationService publicationService = new PublicationServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }
    public ClientService getClientService(){
        return clientService;
    }
    public PublicationService getPublicationService(){
        return publicationService;
    }
}
