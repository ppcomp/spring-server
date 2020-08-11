package com.ppcomp.server.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="crawling_notice")
public class Notice implements Comparable<Notice> {
    @Id
    @Column(name="id", nullable = false)
    String id;

    @Column(name="site", nullable = false)
    @ToString.Exclude String site;

    @Column(name="is_fixed", nullable = false)
    @ToString.Exclude Boolean is_fixed;

    @Column(name="title", nullable = false)
    String title;

    @Column(name="link", nullable = false)
    @ToString.Exclude String link;

    @Column(name="date")
    @ToString.Exclude Date date;

    @Column(name="author")
    @ToString.Exclude String author;

    @Column(name="reference")
    @ToString.Exclude String reference;

    @Override
    public int compareTo(Notice notice) {
        int ret = 0;
        if(!this.is_fixed && notice.is_fixed) {
            ret = -1;
        }
        if(this.is_fixed && notice.is_fixed) {
            if(this.date.compareTo(notice.date) == 0) {
                ret = 0;
            } else if(this.date.compareTo(notice.date) < 0) {
                ret = -1;
            } else if(this.date.compareTo(notice.date) > 0) {
                ret = 1;
            }
        }
        if(this.is_fixed && !notice.is_fixed) {
            ret = 1;
        }
        return ret;
    }
}
