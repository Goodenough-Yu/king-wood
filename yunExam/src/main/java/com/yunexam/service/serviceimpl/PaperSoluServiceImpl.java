package com.yunexam.service.serviceimpl;

import com.yunexam.dao.PaperSoluDao;
import com.yunexam.dao.QuesBankDao;
import com.yunexam.dao.daoimpl.PaperSoluDaoImpl;
import com.yunexam.dao.daoimpl.QuesBankDaoImpl;
import com.yunexam.domain.PaperSolution;
import com.yunexam.domain.QuestionBank;
import com.yunexam.service.PaperSoluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaperSoluServiceImpl implements PaperSoluService {

    @Autowired
    PaperSoluDao paperSoluDao;

    @Autowired
    QuesBankDao quesBankDao;

    @Override
    public boolean InsertSolution(List<PaperSolution> paperSolutions) {
        PaperSolution paperSolution = new PaperSolution();
        for(int i = 0;i<paperSolutions.size();i++){
            paperSolution = paperSolutions.get(i);
            paperSoluDao.AddPaperSolu(paperSolution);
        }
        return false;
    }

    @Override
    public boolean ReviewSolution(int piid, int sid) throws SQLException {
        List<PaperSolution> paperSolutions = new ArrayList<PaperSolution>();
        paperSolutions = paperSoluDao.FindPaperSolu(piid,sid);
        PaperSolution PS = new PaperSolution();
        QuestionBank QB = new QuestionBank();
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
        paperSolutions = paperSoluDao.FindPaperSolu(piid, sid);
        return paperSolutions;
    }

}
