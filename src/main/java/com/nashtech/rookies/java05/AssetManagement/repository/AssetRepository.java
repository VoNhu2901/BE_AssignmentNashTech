package com.nashtech.rookies.java05.AssetManagement.repository;

import com.nashtech.rookies.java05.AssetManagement.model.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {
	@Query(value = "SELECT * FROM assets a WHERE a.category_id LIKE %:category ORDER BY  a.id desc", nativeQuery = true)
	List<Asset> findByOrderByIdDesc(String category);

	@Query(value = "select a.* from information i inner join assets a on i.user_id = a.creator_id where i.location = :location", nativeQuery = true)
	public List<Asset> findAssetByLocation(String location);

	@Query(value = "select a.* from information i inner join assets a on i.user_id = a.creator_id where (lower(a.name) like lower(concat('%', :content,'%')) or lower(a.id) like lower(concat('%', :content,'%'))) and i.location = :location", nativeQuery = true)
	public List<Asset> searchAssetByNameOrCode(String content, String location);

	@Query(value = "select a.* from assets a where a.id = :id and a.state = :state", nativeQuery = true)
	Optional<Asset> findByIdAndState(@Param("id") String id,@Param("state") String state);
}