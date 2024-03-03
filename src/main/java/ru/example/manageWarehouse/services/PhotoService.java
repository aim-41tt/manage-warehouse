package ru.example.manageWarehouse.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {

	public static byte[] convertPhotoToBytes(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			throw new IllegalArgumentException("error: File Empty");
		}
		return  file.getBytes();
	}
	
	
	
}
