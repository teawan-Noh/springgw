package hello.gw.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.gw.dto.ArtistBaseInfo;

public class ArtistBaseInfoRepositoryImpl implements ArtistBaseInfoRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public List<ArtistBaseInfo> artistBaseInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ArtistBaseInfo> artistBaseInfoSelectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
