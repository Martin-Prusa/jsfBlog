package cz.mk.interfaces.services;

import cz.mk.models.Notification;

import java.util.List;

public interface INotificationsService {

    void addNotification(Notification notification);

    List<Notification> getNotification();
}
