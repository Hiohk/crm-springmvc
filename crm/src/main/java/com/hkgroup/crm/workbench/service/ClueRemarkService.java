package com.hkgroup.crm.workbench.service;

import com.hkgroup.crm.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkService {
    List<ClueRemark> queryClueRemarkForDetailBuClueId(String clueId);
}
