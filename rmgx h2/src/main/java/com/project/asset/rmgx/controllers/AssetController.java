package com.project.asset.rmgx.controllers;

import com.project.asset.rmgx.entities.Assets;
import com.project.asset.rmgx.payloads.ApiResponse;
import com.project.asset.rmgx.payloads.AssetDto;
import com.project.asset.rmgx.services.AssetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/api")
public class AssetController {
    @Autowired
    private AssetServices assetServices;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/assets")
    public ResponseEntity<AssetDto> createAsset(@RequestBody AssetDto assetDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        AssetDto createdAsset = this.assetServices.createAsset(assetDto,userId,categoryId);
        return new ResponseEntity<AssetDto>(createdAsset, HttpStatus.CREATED);
    }
    //get by user
    @GetMapping("/user/{userId}/assets")
    public ResponseEntity<List<AssetDto>> getAssetsByUser(@PathVariable Integer userId) {
        List<AssetDto> assets = this.assetServices.getAssetsByUser(userId);
        return new ResponseEntity<List<AssetDto>>(assets,HttpStatus.OK);

    }
    //get by category
    @GetMapping("/category/{categoryId}/assets")
    public ResponseEntity<List<AssetDto>> getAssetsByCategory(@PathVariable Integer categoryId) {
        List<AssetDto> assets = this.assetServices.getAssetsByCategory(categoryId);
        return new ResponseEntity<List<AssetDto>>(assets,HttpStatus.OK);

    }
    //get all assets
    @GetMapping("/assets")
    public ResponseEntity<List<AssetDto>> getAllAssets(){
        List<AssetDto> allAssets = this.assetServices.getAllAssets();
        return new ResponseEntity<List<AssetDto>>(allAssets,HttpStatus.OK);
    }
    // get single asset by asset id
    @GetMapping("/assets/{assetId}")
    public ResponseEntity<AssetDto> getAssetById(@PathVariable Integer assetId){
        AssetDto assetDto = this.assetServices.getAssetById(assetId);
        return new ResponseEntity<AssetDto>(assetDto,HttpStatus.OK);
    }
    //delete asset
    @DeleteMapping("/assets/{assetId}")
    public ApiResponse deleteAsset(@PathVariable Integer assetId){
        this.assetServices.deleteAsset(assetId);
        return new ApiResponse("Asset has been deleted successfully! ",true);
    }
    //update asset
    @PutMapping("/assets/{assetId}")
    public ResponseEntity<AssetDto> updateAsset(@RequestBody AssetDto assetDto, @PathVariable Integer assetId){
        AssetDto assetDto1 = this.assetServices.updateAsset(assetDto,assetId);
        return new ResponseEntity<AssetDto>(assetDto1,HttpStatus.OK);
    }
    // search
    @GetMapping("/assets/search/{keywords}")
    public ResponseEntity<List<AssetDto>> searchByName(@PathVariable("keywords") String keyword){
        List<AssetDto> assetDtos = this.assetServices.searchByName(keyword);
        return new ResponseEntity<List<AssetDto>>(assetDtos,HttpStatus.OK);
    }
}
