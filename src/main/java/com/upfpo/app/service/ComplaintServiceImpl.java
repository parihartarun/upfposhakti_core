package com.upfpo.app.service;


import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.repository.ComplaintCatgoriesRepository;
import com.upfpo.app.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    private final Path root = Paths.get("uploads");

    @Autowired
    private ComplaintCatgoriesRepository complaintCatgoriesRepository;

    public List<Complaints> getAllComplaint(){
        return complaintRepository.findAll();
    }

    public Complaints createComplaint (Complaints complaints){
        return complaintRepository.save(complaints);
    }



    public Complaints updateComplaintDetail(Integer id, Complaints complaints) {
        Optional<Complaints> sd = complaintRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        complaints.setId(id);
        return complaintRepository.save(complaints);
    }


    public Optional deleteComplaint(Integer id) {
        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaintRepository.delete(complaints);
                    return "Delete Successfully!";
                });
    }


    @Override
    public List<ComplaintCatgories> getComplaintsCatgories() {
        return complaintCatgoriesRepository.findAll();
    }


    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }


    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }


    public UrlResource load(String filename) {
        try {
            Path file = root.resolve(filename);
            UrlResource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }


    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}

