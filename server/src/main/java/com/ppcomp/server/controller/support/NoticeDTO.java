package com.ppcomp.server.controller.support;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDTO {
    private String id;
    private String title;
    private String link;
    private Date date;
    private String author;
    private String reference;
    private Boolean is_fixed;

    @Data
    public static class RequestAll extends NoticeDTO {
        private String q;
    }
}