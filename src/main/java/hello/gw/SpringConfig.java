package hello.gw;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.gw.repository.ArtistBaseInfoRepository;
import hello.gw.repository.JpaArtistBaseInfoRepository;
import hello.gw.service.ArtistBaseInfoService;

@Configuration
public class SpringConfig {

	EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	@Bean
	public ArtistBaseInfoService artistBaseInfoService() {
		return new ArtistBaseInfoService(artistBaseInfoRepository());
	}
	
	@Bean
	public ArtistBaseInfoRepository artistBaseInfoRepository() {
		return new JpaArtistBaseInfoRepository(em);
	}
}
