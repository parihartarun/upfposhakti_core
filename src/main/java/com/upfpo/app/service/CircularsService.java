package com.upfpo.app.service;

import com.upfpo.app.entity.Circulars;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
