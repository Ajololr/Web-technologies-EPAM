package by.androsov.periodicals.service;

import by.androsov.periodicals.bean.Publication;

public interface PublicationService {
    void addNewPublication(Publication publication);
    void editPublication(Publication publication);
}
