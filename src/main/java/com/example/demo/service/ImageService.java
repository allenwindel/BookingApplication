package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Transactional
	public Iterable<Image> findAllImage() {

		return imageRepository.findAll();

	}

	@Transactional
	public Image findImageByID(int ID) {

		return imageRepository.findById(ID).get();

	}

	@Transactional
	public Image saveImage(Image image) {

		return imageRepository.save(image);

	}

	@Transactional
	public void deleteImage(List<Integer> imageID) {

		for (Integer id : imageID) {

			imageRepository.deleteById(id);

		}

	}

	@Transactional
	public void deleteImage2(Image image) {

		imageRepository.delete(image);

	}

}