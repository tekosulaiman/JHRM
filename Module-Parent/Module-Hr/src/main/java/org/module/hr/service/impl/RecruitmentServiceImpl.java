package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.TrsJobCandidateDAO;
import org.module.hr.dao.TrsJobVacancyDAO;
import org.module.hr.model.TrsJobCandidate;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.RecruitmentService;

public class RecruitmentServiceImpl implements RecruitmentService{

	private TrsJobVacancyDAO trsJobVacancyDAO;
	private TrsJobCandidateDAO trsJobCandidateDAO;

	/* ------- Vacancy ---------*/
	@Override
	public void save(TrsJobVacancy trsJobVacancy) {
		trsJobVacancyDAO.save(trsJobVacancy);
	}

	@Override
	public void update(TrsJobVacancy trsJobVacancy) {
		trsJobVacancyDAO.update(trsJobVacancy);
	}

	@Override
	public void saveOrUpdate(TrsJobVacancy trsJobVacancy) {
		trsJobVacancyDAO.saveOrUpdate(trsJobVacancy);
	}

	@Override
	public void delete(TrsJobVacancy trsJobVacancy) {
		trsJobVacancyDAO.delete(trsJobVacancy);
	}

	@Override
	public List<TrsJobVacancy> getAllTrsJobVacancy() {
		return trsJobVacancyDAO.getAllTrsJobVacancy();
	}

	@Override
	public TrsJobVacancy getTrsJobVacancyById(Integer id) {
		return trsJobVacancyDAO.getTrsJobVacancyById(id);
	}

	public void setTrsJobVacancyDAO(TrsJobVacancyDAO trsJobVacancyDAO) {
		this.trsJobVacancyDAO = trsJobVacancyDAO;
	}
	
	
	/* ------- Candidate --------*/
	@Override
	public void save(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.save(trsJobCandidate);
	}

	@Override
	public void update(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.update(trsJobCandidate);
	}

	@Override
	public void saveOrUpdate(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.saveOrUpdate(trsJobCandidate);
	}

	@Override
	public void delete(TrsJobCandidate trsJobCandidate) {
		trsJobCandidateDAO.delete(trsJobCandidate);
	}

	@Override
	public List<TrsJobCandidate> getAllTrsJobCandidate() {
		return trsJobCandidateDAO.getAllTrsJobCandidate();
	}

	@Override
	public TrsJobCandidate getTrsJobCandidateById(Integer id) {
		return trsJobCandidateDAO.getTrsJobCandidateById(id);
	}

	public void setTrsJobCandidateDAO(TrsJobCandidateDAO trsJobCandidateDAO) {
		this.trsJobCandidateDAO = trsJobCandidateDAO;
	}
}
