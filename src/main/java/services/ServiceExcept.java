package services;

public class ServiceExcept extends Exception{
    public ServiceExcept(Exception e) {
        super(e);
    }
}