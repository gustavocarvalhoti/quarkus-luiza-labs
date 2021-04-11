USE luizalabs;

CREATE TABLE Receiver
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(50)  NOT NULL,
    cpf      VARCHAR(14)  NULL,
    email    VARCHAR(255) NULL,
    phone    VARCHAR(15)  NULL,
    whatsapp VARCHAR(15)  NULL
);

CREATE TABLE SchedulingNotification
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    status      VARCHAR(10)  NOT NULL,
    created_at  DATETIME     NOT NULL,
    send_date   DATETIME     NOT NULL,
    message     VARCHAR(140) NOT NULL,
    type        VARCHAR(8)   NOT NULL,
    receiver_id INT          NOT NULL,
    CONSTRAINT SchedulingNotification_Receiver
        FOREIGN KEY (receiver_id) REFERENCES Receiver (id)
);

CREATE INDEX receiver_id ON SchedulingNotification (receiver_id);