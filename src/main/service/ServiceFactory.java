package main.service;

/**
 * Intermediate layer between command layer and dao layer.
 * Implements operations of finding, creating, deleting entities.
 * Uses dao layer.
 */
public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        if(instance == null) {
            instance = new ServiceFactory();
        }

        return instance;
    }

    public static CardService getCardService() {
        return CardService.getInstance();
    }

    public static CardTypeService getCardTypeService() {
        return CardTypeService.getInstance();
    }

    public static CreditLimitRequestService getCreditLimitRequestService() {
        return CreditLimitRequestService.getInstance();
    }

    public static StatusService getStatusService() {
        return StatusService.getInstance();
    }

    public static TransferService getTransferService() {
        return TransferService.getInstance();
    }

    public static TransferTypeService getTransferTypeService() {
        return TransferTypeService.getInstance();
    }

    public static UserRoleService getUserRoleService() {
        return UserRoleService.getInstance();
    }

    public static UserService getUserService() {
        return UserService.getInstance();
    }
}
