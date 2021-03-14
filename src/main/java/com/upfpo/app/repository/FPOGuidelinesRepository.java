package com.upfpo.app.repository;

import com.upfpo.app.dto.FPOGuidelinesDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOGuidelineType;
import com.upfpo.app.entity.FPOGuidelines;
import com.upfpo.app.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FPOGuidelinesRepository extends JpaRepository<FPOGuidelines, Integer> {

    List<FPOGuidelines> findByIsDeleted(Boolean b);

    List<FPOGuidelines> findByFpoGuidelineType(FPOGuidelineType type);

    List<FPOGuidelines> findByIsDeletedOrderByIdDesc(boolean b);

    List<FPOGuidelines> findByFpoGuidelineTypeOrderByIdDesc(FPOGuidelineType preregistration);

    List<FPOGuidelines> findByFpoGuidelineTypeAndLanguageOrderByIdDesc(FPOGuidelineType guidelineType, Language lang);



    List<FPOGuidelinesDTO> getByRegistrationType (FPOGuidelineType type);

    //@Query("SELECT new com.upfpo.app.dto.FPOGuidelinesDTO(id, hindi_description, create_date, file_path) FROM FPOGuidelines where fpoGuidelineType=:type")
   /* @Query("SELECT new com.upfpo.app.dto.FPOGuidelinesDTO(id, hindi_description, create_date, file_path)  FROM FPOGuidelines WHERE fpoGuidelineType=:#{#type.name()}" +
            " and (:hindiDescription is null)")
    List<FPOGuidelinesDTO> getByLanguage(FPOGuidelineType type);*/
}
