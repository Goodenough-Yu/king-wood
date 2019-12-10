package com.yunexam.service.serviceimpl;

import com.yunexam.dao.ExamInforDao;
import com.yunexam.dao.daoimpl.ExamInforDaoImpl;
import com.yunexam.domain.ExamInformation;
import com.yunexam.service.ExamInfoService;

import java.sql.SQLException;
import java.util.List;

public class ExamInfoServiceImpl implements ExamInfoService {

    @Override
    public boolean AddExamInfo(ExamInformation EI) {
        ExamInforDao examInforDao = new ExamInforDaoImpl();
        return examInforDao.AddExamInfo(EI);
    }

    @Override
    public List<ExamInformation> FindExamInfo() throws SQLException {
        ExamInforDao examInforDao = new ExamInforDaoImpl();
        return examInforDao.FindExamInfo();
    }

    @Override
    public ExamInformation FindExamInfoByeiid(int eiid) throws SQLException {
        ExamInforDao examInforDao = new ExamInforDaoImpl();
        return examInforDao.FindExamInfoByeiid(eiid);
    }
}
