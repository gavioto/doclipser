package com.zenika.docker.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

public final class DockerClientFactory {
	
	public static DockerClient makeDockerClient() {
		String dockerClientClassName = getDockerClientClassName();
		return makeDockerClient(dockerClientClassName);
	}
	
	public static DockerClient makeDockerClient(String dockerClientClassName) {
		try {
			return (DockerClient) Class.forName(dockerClientClassName)
					.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String getDockerClientClassName() {
		final URL url = Resources.getResource(Constants.PROPERTY_FILE_NAME);
		final ByteSource byteSource = Resources.asByteSource(url);
		final Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = byteSource.openBufferedStream();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (final IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
		return properties.getProperty(Constants.PROPERTY_DOCKER_CLIENT_LIB);
	}

}
