package com.yunexam.dao.daoimpl;

import com.yunexam.dao.PaperInfoDao;
import com.yunexam.domain.PaperInformation;

public class PaperInfoDaoImpl implements PaperInfoDao {
    @Override
    public boolean AddPaperInfo(PaperInformation PI) {
        return false;
    }

    @Override
    public PaperInformation FindPaperInfoBypiid(int piid) {
        return null;
    }

    @Override
    public PaperInformation FindPaperInfoByeiid(int piid, int eiid) {
        return null;
    }
}
