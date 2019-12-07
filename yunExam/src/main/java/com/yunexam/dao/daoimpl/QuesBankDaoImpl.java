package com.yunexam.dao.daoimpl;

import com.yunexam.dao.QuesBankDao;
import com.yunexam.domain.QuestionBank;

public class QuesBankDaoImpl implements QuesBankDao {
    @Override
    public boolean AddQuesBank(QuestionBank QB) {
        return false;
    }

    @Override
    public QuestionBank FindQuesBankByqbid(int qbid) {
        return null;
    }

    @Override
    public int[] FindQuestion(int cid, int is_single, int degree) {
        return new int[0];
    }
}
