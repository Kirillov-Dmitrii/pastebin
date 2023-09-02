package com.petproject.pastebin.model;

import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column
    private Date deleteDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
