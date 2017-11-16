package nova.devday.persistent;

import java.util.List;

import com.nova.devday.CandidateInfo;

import ch.ivyteam.ivy.environment.Ivy;

public class CrawlingPersistentService {

		
		public CandidateInfo addCandidate(CandidateInfo candidateInfo){
			return Ivy.persistence().get("nova_candidate_crawling").persist(candidateInfo);
		}
		
		public List<CandidateInfo> getCandidateInfoList(){
			return Ivy.persistence().get("nova_candidate_crawling").findAll(CandidateInfo.class);
		}
}
