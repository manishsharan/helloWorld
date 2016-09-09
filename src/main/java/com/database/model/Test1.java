package com.database.model;

import com.yammer.dropwizard.json.JsonSnakeCase;
import lombok.*;

import javax.persistence.*;

/**
 * Created by manish.sharan on 10/09/16
 */
@JsonSnakeCase
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "test1")
public class Test1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
