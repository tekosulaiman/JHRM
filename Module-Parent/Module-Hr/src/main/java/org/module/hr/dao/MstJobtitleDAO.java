package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.MstJobtitle;

public interface MstJobtitleDAO {
	public void save(MstJobtitle mstJobtitle);
    public void update(MstJobtitle mstJobtitle);
    public void saveOrUpdate(MstJobtitle mstJobtitle);
    public void delete(MstJobtitle mstJobtitle);
    public List<MstJobtitle> getAllMstJobtitles();
    public List<MstJobtitle> getByRequestMstJobtitles(HashMap<String, Object> hashMap);
    public List<MstJobtitle> getByRequestMap(Map<String, Object> requestMap);
    public Long getCountMsJobtitles();
}