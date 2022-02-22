package hello.gw.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import hello.gw.dto.ArtistBaseInfo;

public class JpaArtistBaseInfoRepository implements ArtistBaseInfoRepository {

	private final EntityManager em;
	
	public JpaArtistBaseInfoRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<ArtistBaseInfo> artistBaseInfoAll() {
		return em.createQuery("select m from ArtistBaseInfo m", ArtistBaseInfo.class).getResultList();
		
	}

	@Override
	public Optional<ArtistBaseInfo> artistBaseInfoSelectByName(String nm) {
		List<ArtistBaseInfo> result = em.createQuery("select m from ArtistBaseInfo m where m.nm = :nm", ArtistBaseInfo.class).setParameter("nm", nm).getResultList();
		return result.stream().findAny();
	}

}
