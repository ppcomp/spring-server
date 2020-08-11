package com.ppcomp.server.service;

import com.ppcomp.server.entity.Notice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    SessionFactory sessionFactory;

    public List<Notice> getAll(final String q) {
        Session session = sessionFactory.getCurrentSession();
        List<Notice> results = new ArrayList<>();
        String[] siteArr = q.split("\\+");
        String sites = String.join(",", siteArr);
        String hql = "from crawling_notice where site in ("+sites+")";
        Query query = session.createQuery(hql);
        query.setParameterList("names", results);
        return results;
    }
}