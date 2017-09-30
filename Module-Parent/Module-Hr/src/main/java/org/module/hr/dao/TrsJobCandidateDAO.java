package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsJobCandidate;

public interface TrsJobCandidateDAO {

	public void save(TrsJobCandidate trsJobCandidate);
    public void update(TrsJobCandidate trsJobCandidate);
    public void saveOrUpdate(TrsJobCandidate trsJobCandidate);
    public void delete(TrsJobCandidate trsJobCandidate);
    public List<TrsJobCandidate> getAllTrsJobCandidate();
    public TrsJobCandidate getTrsJobCandidateById(Integer id);
	public List<TrsJobCandidate> getByRequest(HashMap<String, Object> params);
}
