package com.hkgroup.crm.workbench.service.impl;

import com.hkgroup.crm.workbench.domain.ClueRemark;
import com.hkgroup.crm.workbench.mapper.ClueMapper;
import com.hkgroup.crm.workbench.mapper.ClueRemarkMapper;
import com.hkgroup.crm.workbench.service.ClueRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clueRemarkService")
public class ClueRemarkServiceImpl implements ClueRemarkService {
    @Autowired
    private ClueRemarkMapper clueRemarkMapper;
    @Override
    public List<ClueRemark> queryClueRemarkForDetailBuClueId(String clueId) {
        return clueRemarkMapper.selectClueRemarkForDetailByClueId(clueId);
    }
}
