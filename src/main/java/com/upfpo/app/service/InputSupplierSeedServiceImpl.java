package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.InputSupplierMachineryDTO;
import com.upfpo.app.dto.InputSupplierSeedDTO;
import com.upfpo.app.entity.InputSupplierSeed;
import com.upfpo.app.entity.Status;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.InputSupplierSeedRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class InputSupplierSeedServiceImpl implements InputSupplierSeedService {

    @Autowired
    private InputSupplierSeedRepository seedRepository;


    private final Path fileStorageLocation;

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data");

    @Autowired
    private EntityManager entityManager;


    @Autowired
    public InputSupplierSeedServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }


    @Override
    public List<InputSupplierSeedDTO> getAllInputSupplierSeed(Integer masterId){
        List<InputSupplierSeedDTO> seed = getSeedDetail(masterId);
        return seed;
    }

    @Override
    public InputSupplierSeed createInputSupplierSeed(InputSupplierSeed inputSupplierSeed, MultipartFile file){
        String fileName = null;
        inputSupplierSeed.setCreateBy(inputSupplierSeed.getInputSupplierId());
        inputSupplierSeed.setCreateDateTime(Calendar.getInstance());
        if(file!=null){
        try {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileContentType = file.getContentType();
            // Check if the file's name contains invalid characters
            if(fileName.contains("..") && contentTypes.contains(fileContentType)) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence or invalid file type " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/inputsupplier/seed/download/")
                    .path(fileName)
                    .toUriString();
            inputSupplierSeed.setFilePath(fileDownloadUri);
            inputSupplierSeed.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }}
        inputSupplierSeed.setDeleted(false);
        return seedRepository.save(inputSupplierSeed);
    }

    @Override
    public Boolean deleteInputSupplierSeed(Integer id) {
        try {
            InputSupplierSeed inputSupplierSeed = seedRepository.findById(id).get();
            inputSupplierSeed.setDeleted(true);
            inputSupplierSeed.setDeleteDate(Calendar.getInstance());
            seedRepository.save(inputSupplierSeed);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
    }




    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            //Path path = Paths.get( fileBasePath+fileName);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new ResourceNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new ResourceNotFoundException("File not found " + fileName, ex);
        }
    }

    @Override
    public InputSupplierSeed updateInputSupplierSeed(Integer id, InputSupplierSeed inputSupplierSeed1,  MultipartFile file) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String fileDownloadUri;
        String fileName;
        Path targetLocation;

        if(file!=null){
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileContentType = file.getContentType();
            try {
                // Check if the file's name contains invalid characters

                if (fileName.contains("..") && contentTypes.contains(fileContentType)) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                targetLocation = this.fileStorageLocation.resolve(fileName);
                //Path path = Paths.get( fileBasePath+fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/inputsupplier/seed/download/")
                        .path(fileName)
                        .toUriString();
                seedRepository.findById(id)
                        .map(inputSupplierSeed -> {
                            inputSupplierSeed.setFilePath(fileDownloadUri);
                            inputSupplierSeed.setFileName(fileName);
                            return seedRepository.saveAndFlush(inputSupplierSeed);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        return seedRepository.findById(id)
                .map(inputSupplierSeed -> {
                    inputSupplierSeed.setUpdateBy(inputSupplierSeed1.getInputSupplierId());
                    inputSupplierSeed.setUpdateDate(Calendar.getInstance());
                    inputSupplierSeed.setDeleted(false);
                    inputSupplierSeed.setCropId(inputSupplierSeed1.getCropId());
                    inputSupplierSeed.setVariety(inputSupplierSeed1.getVariety());
                    inputSupplierSeed.setInputSupplierId(inputSupplierSeed1.getInputSupplierId());
                    inputSupplierSeed.setCertificationNumber(inputSupplierSeed1.getCertificationNumber());
                    inputSupplierSeed.setQuantity(inputSupplierSeed1.getQuantity());
                    inputSupplierSeed.setCompanyBrand(inputSupplierSeed1.getCompanyBrand());
                    inputSupplierSeed.setCertificationValidFrom(inputSupplierSeed1.getCertificationValidFrom());
                    inputSupplierSeed.setCertificationValidTo(inputSupplierSeed1.getCertificationValidTo());
                    return seedRepository.save(inputSupplierSeed);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


    public List<InputSupplierSeedDTO> getSeedDetail(Integer masterId) {
        List<InputSupplierSeedDTO> list = null;
        try {
            String sql = "Select  iss.id, cm.id as crop_id, cm.crop_name, cvm.veriety_id, cvm.crop_veriety, iss.company_brand, iss.quantity, iss.certification_number \r\n" +
                    ", iss.certification_valid_from, iss.certification_valid_to, iss.file_path \r\n" +
                    "from input_supplier_seed iss \r\n" +
                    "left join  crop_master cm on cm.id=iss.crop_id \r\n" +
                    "left join crop_veriety_master cvm on cvm.veriety_id=iss.variety_id \r\n" +
                    "inner join input_supplier isup on iss.input_supplier_id=isup.input_supplier_id \r\n" +
                    "where iss.input_supplier_id=:masterId and  iss.is_deleted = false";

            List<InputSupplierSeedDTO> obj = (List<InputSupplierSeedDTO>) entityManager.createNativeQuery(sql, "InputSupplierSeedDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
