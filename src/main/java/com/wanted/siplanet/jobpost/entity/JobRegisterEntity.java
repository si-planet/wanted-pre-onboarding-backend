package com.wanted.siplanet.jobpost.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jobregister")
public class JobRegisterEntity extends BaseEntity{

    @EmbeddedId
    private JobRegisterId id;

    @ManyToOne
    @MapsId("jpNum")
    @JoinColumn(name="jp_num")
    JobPostEntity jp;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    UserEntity user;

}
