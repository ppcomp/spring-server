package com.ppcomp.server.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="crawling_notice")
public class Notice implements Comparable<Notice> {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name="site", nullable = false)
    String site;

    @Column(name="is_fixed", nullable = false)
    Boolean is_fixed;

    @Column(name="title", nullable = false)
    String title;

    @Column(name="link", nullable = false)
    String link;

    @Column(name="date")
    Date date;

    @Column(name="author")
    String author;

    @Column(name="reference")
    String reference;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Boolean getFixed() {
        return is_fixed;
    }

    public void setFixed(Boolean fixed) {
        is_fixed = fixed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }

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
