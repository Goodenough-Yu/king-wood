package com.yunexam.service.serviceimpl;

import com.yunexam.dao.QuesBankDao;
import com.yunexam.dao.daoimpl.QuesBankDaoImpl;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.TestService;

import java.sql.SQLException;

public class TestServiceImpl implements TestService {

    QuesBankDao quesBankDao = new QuesBankDaoImpl();

    QuestionBank QB = null;

    @Override
    public void PrintPaper() throws SQLException {
        QB = new QuestionBank();
        QB = quesBankDao.FindQuesBankByqbid(1);

        System.out.println(QB.getQuestion());
        System.out.println(QB.getA());
        System.out.println(QB.getB());
        System.out.println("Helloword!");
    }
}
