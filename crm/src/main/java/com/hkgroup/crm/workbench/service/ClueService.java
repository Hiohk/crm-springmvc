package com.hkgroup.crm.workbench.service;

import com.hkgroup.crm.workbench.domain.Clue;

public interface ClueService {
    int saveCreateClue(Clue clue);

    Clue queryClueForDetailById(String id);
}
