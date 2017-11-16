package nova.devday.persistent;

import java.util.List;

import com.nova.devday.CandidateInfo;

import ch.ivyteam.ivy.environment.Ivy;

public class CrawlingPersistentService {
		
		private static final String PERSISTENT_NAME = "nova_candidate_crawling";

		public CandidateInfo addCandidate(CandidateInfo candidateInfo){
			return Ivy.persistence().get(PERSISTENT_NAME).persist(candidateInfo);
		}
		
		public List<CandidateInfo> getCandidateInfoList(){
			return Ivy.persistence().get(PERSISTENT_NAME).findAll(CandidateInfo.class);
		}
}
