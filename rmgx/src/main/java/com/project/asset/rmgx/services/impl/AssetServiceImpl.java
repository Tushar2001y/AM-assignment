package com.project.asset.rmgx.services.impl;

import com.project.asset.rmgx.entities.Assets;
import com.project.asset.rmgx.entities.Category;
import com.project.asset.rmgx.entities.User;
import com.project.asset.rmgx.exceptions.ResourceNotFoundException;
import com.project.asset.rmgx.payloads.AssetDto;
import com.project.asset.rmgx.repositories.AssetRepo;
import com.project.asset.rmgx.repositories.CategoryRepo;
import com.project.asset.rmgx.repositories.UserRepo;
import com.project.asset.rmgx.services.AssetServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetServices {
    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public AssetDto createAsset(AssetDto assetDto,Integer userId,Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        Assets assets = this.modelMapper.map(assetDto,Assets.class);
        assets.setUser(user);
        assets.setCategory(category);

        Assets newAsset = this.assetRepo.save(assets);

        return this.modelMapper.map(newAsset,AssetDto.class);
    }

    @Override
    public AssetDto updateAsset(AssetDto assetDto, Integer assetId) {
        Assets assets = this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","AssetId",assetId));
        assets.setName(assetDto.getName());
        assets.setAssignmentStatus(assetDto.getAssignmentStatus());
        assets.setConditionNote(assetDto.getConditionNote());
        assets.setPurchaseDate(assetDto.getPurchaseDate());

        Assets updateAsset = this.assetRepo.save(assets);
        AssetDto assetDto1 = this.modelMapper.map(updateAsset,AssetDto.class);
        return assetDto1;
    }

    @Override
    public void deleteAsset(Integer assetId) {
        Assets assets = this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","AssetId",assetId));
        this.assetRepo.delete(assets);
    }

    @Override
    public List<AssetDto> getAllAssets() {
        List<Assets> allAssets = this.assetRepo.findAll();
        List<AssetDto> assetDtos = allAssets.stream().map((allAssets1) -> this.modelMapper.map(allAssets1,AssetDto.class)).collect(Collectors.toList());

        return assetDtos;
    }

    @Override
    public List<AssetDto> searchByName(String keyword) {
        List<Assets> assets = this.assetRepo.findByName(keyword);
        List<AssetDto> assetDtos = assets.stream().map((assets1)->this.modelMapper.map(assets1,AssetDto.class)).collect(Collectors.toList());

        return assetDtos;
    }



    @Override
    public AssetDto getAssetById(Integer assetId) {
        Assets assets = this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","AssetId",assetId));

        return this.modelMapper.map(assets,AssetDto.class);
    }

    @Override
    public List<AssetDto> getAssetsByCategory(Integer categoryId) {
        Category cat  = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        List<Assets> assets = this.assetRepo.findByCategory(cat);
        List<AssetDto> assetDtos = assets.stream().map((assets1) -> this.modelMapper.map(assets1,AssetDto.class)).collect(Collectors.toList());
        return assetDtos;
    }

    @Override
    public List<AssetDto> getAssetsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
        List<Assets> assets = this.assetRepo.findByUser(user);
        List<AssetDto> assetDtos = assets.stream().map((assets1)->this.modelMapper.map(assets1,AssetDto.class)).collect(Collectors.toList());
        return assetDtos;
    }
}
