package com.hkgroup.crm.settings.service.impl;

import com.hkgroup.crm.settings.domain.DicValue;
import com.hkgroup.crm.settings.mapper.DicValueMapper;
import com.hkgroup.crm.settings.service.DicValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dicValueService")
public class DicValueServiceImpl implements DicValueService {
    @Autowired
    private DicValueMapper dicValueMapper;

    @Override
    public List<DicValue> queryDiCValueByTypeCode(String typeCode) {
        return dicValueMapper.selectDicValueByTypeCode(typeCode);
    }
}
