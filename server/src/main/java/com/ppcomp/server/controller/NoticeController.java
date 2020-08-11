package com.ppcomp.server.controller;

import com.ppcomp.server.controller.support.NoticeDTO;
import com.ppcomp.server.entity.Notice;
import com.ppcomp.server.repository.NoticeRepository;
import com.ppcomp.server.service.NoticeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeRepository noticeRepository;

    @Autowired
    NoticeService noticeService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity noticeAll(@RequestParam String q) {
        Iterable<Notice> noticeIter;
        if (q != null) {
            noticeIter = noticeService.getAll(q);
        } else {
            noticeIter = noticeRepository.findAll();
        }
        return new ResponseEntity<>(modelMapper.map(noticeIter, NoticeDTO.class), HttpStatus.OK);
    }

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public Iterable<Notice> noticeAll(@RequestParam String q) {
//        String[] split = q.split("\\+");
//        Stream<String> stream = Arrays.stream(split);
//        return noticeRepository.findAllById((Iterable<String>) stream);
//    }

    @RequestMapping("/init/{board}/{pages}")
    public String noticeInit(@PathVariable String board, @PathVariable int pages) {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/init/{pages}")
    public String noticeInit(@PathVariable int pages) {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/list")
    public String noticeList() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/search")
    public String noticeSearch(@RequestParam String q) {
        return "Greetings from Spring Boot!";
    }
}
