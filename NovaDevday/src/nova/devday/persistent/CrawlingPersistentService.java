package nova.devday.persistent;

import java.util.List;

import com.nova.devday.CandidateInfo;

import ch.ivyteam.ivy.environment.Ivy;

public class CrawlingPersistentService {
		

		public String addCandidate(CandidateInfo candidateInfo){
			return Ivy.repo().save(candidateInfo).getId();
		}
		
		public List<CandidateInfo> getCandidateInfoList(){
			return Ivy.repo().search(CandidateInfo.class).execute().getAll();
		}
}
