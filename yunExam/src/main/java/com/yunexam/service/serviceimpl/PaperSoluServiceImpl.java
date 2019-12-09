package com.yunexam.service.serviceimpl;

import com.yunexam.domain.PaperSolution;
import com.yunexam.service.PaperSoluService;

import java.util.List;

public class PaperSoluServiceImpl implements PaperSoluService {

    @Override
    public int InsertSolution(List<PaperSolution> paperSolutions) {
        return 0;
    }

    @Override
    public boolean ReviewSolution(int piid, int sid) {
        return false;
    }

    @Override
    public List<PaperSolution> FindSolution(int piid, int sid) {
        return null;
    }

    @Override
    public List<Integer> FindAllPaper(int sid) {
        return null;
    }
}
