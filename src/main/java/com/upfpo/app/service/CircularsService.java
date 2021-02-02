package com.upfpo.app.service;

import com.upfpo.app.entity.Circulars;
import com.upfpo.app.entity.FileStorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface CircularsService {

/*    public void init();

    public void save(MultipartFile file);

    public UrlResource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();*/

    public Boolean deleteCircular(Integer id);
    public Circulars updateCirculars(Integer id, Circulars circulars1, String description, MultipartFile file);
    public Resource loadFileAsResource(String fileName);
    public Circulars createCircular (Circulars  circulars, MultipartFile file);
    public List<Circulars> getCirculars();

}
