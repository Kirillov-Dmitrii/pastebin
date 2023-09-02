package com.petproject.pastebin.model;

import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column
    @ColumnTransformer(write = "LOWER(?)")
    private String nickname;

    @OneToMany(mappedBy = "user")
    @Column
    private List<Message> messages;

}
