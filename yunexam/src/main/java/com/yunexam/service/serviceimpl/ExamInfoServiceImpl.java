package com.yunexam.service.serviceimpl;

import com.yunexam.dao.ExamInforDao;
import com.yunexam.dao.daoimpl.ExamInforDaoImpl;
import com.yunexam.domain.ExamInformation;
import com.yunexam.service.ExamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ExamInfoServiceImpl implements ExamInfoService {

    @Autowired
    ExamInforDao examInforDao;

    @Override
    public boolean AddExamInfo(ExamInformation EI) {
        return examInforDao.AddExamInfo(EI);
    }

    @Override
    public List<ExamInformation> FindExamInfo() throws SQLException {
        return examInforDao.FindExamInfo();
    }

    @Override
    public ExamInformation FindExamInfoByeiid(int eiid) throws SQLException {
        return examInforDao.FindExamInfoByeiid(eiid);
    }
}
