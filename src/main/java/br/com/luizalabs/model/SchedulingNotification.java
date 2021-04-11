package br.com.luizalabs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class SchedulingNotification extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "send_date")
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendDate;

    @Column(name = "receiver_id")
    @JsonbTransient
    private Long receiverId;

    @Transient
    private List<Receiver> receivers;

    @Transient
    private Receiver receiver;

    private String message;
    private String type;
    private String status;

    public SchedulingNotification(SchedulingNotification schedulingNotification) {
        this.status = schedulingNotification.status;
        this.createdAt = schedulingNotification.createdAt;
        this.sendDate = schedulingNotification.sendDate;
        this.message = schedulingNotification.message;
        this.type = schedulingNotification.type;
        this.receiverId = schedulingNotification.receiverId;
    }

    public SchedulingNotification() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receiver> receivers) {
        this.receivers = receivers;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}