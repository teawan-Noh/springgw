package hello.gw.repository;

import java.util.List;
import java.util.Optional;

import hello.gw.dto.ArtistBaseInfo;

public interface ArtistBaseInfoRepository {

	public List<ArtistBaseInfo> artistBaseInfoAll();
	public Optional<ArtistBaseInfo> artistBaseInfoSelectByName(String name);
	
}
