package hello.gw.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.gw.dto.ArtistBaseInfo;
import hello.gw.repository.ArtistBaseInfoRepository;

@Transactional
public class ArtistBaseInfoService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArtistBaseInfoRepository artistBaseInfoRepository;
	
	public ArtistBaseInfoService(ArtistBaseInfoRepository artistBaseInfoRepository) {
		this.artistBaseInfoRepository = artistBaseInfoRepository;
	}

	public Optional<ArtistBaseInfo> artistBaseInfoSelectByName(String nm) {
		return artistBaseInfoRepository.artistBaseInfoSelectByName(nm);
	}
	
	/**
	 * 전체 조회
	 */
	public List<ArtistBaseInfo> artistBaseInfoAll() {
		logger.info(artistBaseInfoRepository.artistBaseInfoAll().toString());
		
		return artistBaseInfoRepository.artistBaseInfoAll();
	}
}
