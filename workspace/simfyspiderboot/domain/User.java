package edu.cqjtu.zhang.simfyspiderboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Lewis
 */
@Data
@Entity
@Table(name = "simfyspider_user")
public class User {

    @Id
    /**
     * 自动生成ID
      */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private Date lassLoginTime;



}
