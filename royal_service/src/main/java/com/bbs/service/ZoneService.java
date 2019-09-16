package com.bbs.service;

import com.bbs.domain.BbsZoneTable;

import java.util.List;

public interface ZoneService {
    List<BbsZoneTable> findAll() throws Exception;
}
