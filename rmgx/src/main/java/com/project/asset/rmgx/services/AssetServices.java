package com.project.asset.rmgx.services;

import com.project.asset.rmgx.entities.Assets;
import com.project.asset.rmgx.payloads.AssetDto;

import java.util.List;

public interface AssetServices {
    //create
    AssetDto createAsset(AssetDto assetDto,Integer userId,Integer categoryId);
    //update
    AssetDto  updateAsset(AssetDto assetDto,Integer assetId);
    //delete
    void deleteAsset(Integer assetId);
    //get all assets
    List<AssetDto> getAllAssets();
    //get single asset by name
    List<AssetDto> searchByName(String keyword);
    //get single asset by id
    AssetDto getAssetById(Integer assetId);
    //get all assets by category
    List<AssetDto> getAssetsByCategory(Integer categoryId);
    //get all assets by user
    List<AssetDto> getAssetsByUser(Integer userId);
}
