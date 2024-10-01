package com.hkgroup.crm.settings.service;

import com.hkgroup.crm.settings.domain.DicValue;

import java.util.List;

public interface DicValueService {
    List<DicValue> queryDiCValueByTypeCode(String typeCode);
}
