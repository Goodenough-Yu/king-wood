package com.yunexam.service.serviceimpl;

import com.yunexam.dao.PaperSoluDao;
import com.yunexam.dao.QuesBankDao;
import com.yunexam.dao.daoimpl.PaperSoluDaoImpl;
import com.yunexam.dao.daoimpl.QuesBankDaoImpl;
import com.yunexam.domain.PaperSolution;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.PaperSoluService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperSoluServiceImpl implements PaperSoluService {


    @Override
    public boolean InsertSolution(List<PaperSolution> paperSolutions) {

        return false;
    }

    @Override
    public boolean ReviewSolution(int piid, int sid) throws SQLException {
        PaperSoluDao paperSoluDao = new PaperSoluDaoImpl();
        List<PaperSolution> paperSolutions = new ArrayList<PaperSolution>();
        paperSolutions = paperSoluDao.FindPaperSolu(piid,sid);
        PaperSolution PS = new PaperSolution();
        QuestionBank QB = new QuestionBank();
        QuesBankDao quesBankDao = new QuesBankDaoImpl();
        int qbid;
        String solution;
        String answer;
        for(int i = 0;i<paperSolutions.size();i++){
            PS = paperSolutions.get(i);
            qbid = PS.getQbid();
            solution = PS.getSolution();
            QB = quesBankDao.FindQuesBankByqbid(qbid);
            answer = QB.getAnswer();
            if(solution == answer){
                PS.setPsscore(10);
                paperSoluDao.UpdatePaperSolu(PS);
            }
            else{
                PS.setPsscore(0);
                paperSoluDao.UpdatePaperSolu(PS);
            }
        }
        return false;
    }

    @Override
    public List<PaperSolution> FindSolution(int piid, int sid) throws SQLException {
        List<PaperSolution> paperSolutions = new ArrayList<PaperSolution>();
        PaperSoluDao paperSoluDao = new PaperSoluDaoImpl();
        paperSolutions = paperSoluDao.FindPaperSolu(piid, sid);
        return paperSolutions;
    }

}
