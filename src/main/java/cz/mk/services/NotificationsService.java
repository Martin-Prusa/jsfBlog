package cz.mk.services;

import cz.mk.interfaces.services.INotificationsService;
import cz.mk.models.Notification;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class NotificationsService implements INotificationsService, Serializable {

    private List<Notification> notifications = new ArrayList<>();

    @Override
    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    @Override
    public List<Notification> getNotification() {
        List<Notification> tmp = notifications;
        notifications = new ArrayList<>();
        return tmp;
    }
}
