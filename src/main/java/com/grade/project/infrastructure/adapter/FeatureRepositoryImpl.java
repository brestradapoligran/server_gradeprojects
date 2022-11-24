package com.grade.project.infrastructure.adapter;

import com.grade.project.domain.dto.FeatureDto;
import com.grade.project.domain.dto.UserDto;
import com.grade.project.domain.model.FeatureModel;
import com.grade.project.domain.port.FeatureRepository;
import com.grade.project.infrastructure.document.FeatureDocument;
import com.grade.project.infrastructure.document.UserDocument;
import com.grade.project.infrastructure.mongorepository.FeatureMongoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class FeatureRepositoryImpl implements FeatureRepository {

    private final FeatureMongoRepository featureMongoRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public FeatureDto createFeature(FeatureModel featureModel) {
        return this.saveFeature(featureModel);
    }

    @Override
    public FeatureDto updateFeature(FeatureModel featureModel) {
        this.getFeatureById(featureModel.getId());
        return this.saveFeature(featureModel);
    }

    @Override
    public void deleteFeature(String id) {
        this.featureMongoRepository.deleteById(id);
    }

    @Override
    public FeatureDto getFeature(String id) {
        return this.getFeatureById(id);
    }

    @Override
    public List<FeatureDto> getAllFeatures() {
        List<FeatureDocument> featureDocuments = this.featureMongoRepository.findAll();
        return featureDocuments.stream().map(feature -> this.mapper.map(feature, FeatureDto.class)).collect(Collectors.toList());
    }

    private FeatureDto saveFeature(FeatureModel featureModel) {
        FeatureDocument featureDocument = this.mapper.map(featureModel, FeatureDocument.class);
        FeatureDocument featureSaved = this.featureMongoRepository.save(featureDocument);
        return this.mapper.map(featureSaved, FeatureDto.class);
    }

    private FeatureDto getFeatureById(String id) {
        Optional<FeatureDocument> featureFound = this.featureMongoRepository.findById(id);
        if(featureFound.isPresent()) {
            return this.mapper.map(featureFound.get(), FeatureDto.class);
        } else {
            throw new RuntimeException("");
        }
    }
}
