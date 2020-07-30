package com.tts.lcy;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FastdfsApplication.class)
public class FastdfsApplicationTests {


	@Autowired
	private FastFileStorageClient storageClient;
	@Autowired
	private ThumbImageConfig thumbImageConfig;

	@Test
	public void contextLoads() throws FileNotFoundException {

		File file = new File("C:/Users/Administrator/Pictures/表情图/1.gif");
		System.out.println(file.length());
		StorePath storePath = storageClient.uploadFile(new FileInputStream(file), file.length(), "gif", null);
		System.out.println(storePath.getFullPath());
		System.out.println(storePath.getPath());

		// 获取缩略图路径
		String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
		System.out.println(path);


	}

}
