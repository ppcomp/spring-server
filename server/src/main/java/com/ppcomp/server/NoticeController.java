package com.ppcomp.server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @RequestMapping("/notice/all")
    public String noticeAll() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/notice/all")
    public String noticeAll(@RequestParam String q) {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/notice/init/{board}/{pages}")
    public String noticeInit(@PathVariable String board, @PathVariable int pages) {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/notice/init/{pages}")
    public String noticeInit(@PathVariable int pages) {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/notice/list")
    public String noticeList() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/notice/search")
    public String noticeSearch(@RequestParam String q) {
        return "Greetings from Spring Boot!";
    }
}
