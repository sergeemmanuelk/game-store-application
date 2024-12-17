package dev.skonan.store.notification;

import dev.skonan.store.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {
    private String message;
    private String receiver;
    private NotificationLevel level;
    private NotificationStatus status;
}
