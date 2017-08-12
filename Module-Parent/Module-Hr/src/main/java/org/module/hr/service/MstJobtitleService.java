package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstJobtitle;

public interface MstJobtitleService {
	public void save(MstJobtitle mstJobtitle);
    public void update(MstJobtitle mstJobtitle);
    public void saveOrUpdate(MstJobtitle mstJobtitle);
    public void delete(MstJobtitle mstJobtitle);
    public List<MstJobtitle> getAllMstJobtitles();
}
