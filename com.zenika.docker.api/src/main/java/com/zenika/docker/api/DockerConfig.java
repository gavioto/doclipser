package com.zenika.docker.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

public class DockerConfig {
	private final String version;
	private final String uri;
	private final String username;
	private final String password;
	private final String email;
	private final String serverAddress;
	private final String dockerCertPath;

	public DockerConfig() {
		Properties properties = getPropertyFile();
		version = properties.getProperty(Constants.PROPERTY_DOCKER_API_VERSION);
		uri = properties.getProperty(Constants.PROPERTY_DOCKER_URI);
		username = properties.getProperty(Constants.PROPERTY_USERNAME);
		password = properties.getProperty(Constants.PROPERTY_PASSWORD);
		email = properties.getProperty(Constants.PROPERTY_EMAIL);
		serverAddress = properties
				.getProperty(Constants.PROPERTY_DOCKER_SERVER_ADDRESS);
		dockerCertPath = properties
				.getProperty(Constants.PROPERTY_DOCKER_CERT_PATH);
	}

	private Properties getPropertyFile() {
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
		return properties;
	}

	public String getVersion() {
		return version;
	}

	public String getUri() {
		return uri;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public String getDockerCertPath() {
		return dockerCertPath;
	}
}
