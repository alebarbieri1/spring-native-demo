package com.example.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.internal.config.*;
import com.amazonaws.partitions.model.*;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.secretsmanager.AwsSecretsManagerBootstrapConfiguration;
import org.springframework.cloud.aws.core.config.AmazonWebserviceClientFactoryBean;
import org.springframework.cloud.aws.core.credentials.CredentialsProviderFactoryBean;
import org.springframework.cloud.aws.core.region.StaticRegionProvider;
import org.springframework.cloud.aws.secretsmanager.AwsSecretsManagerPropertySource;
import org.springframework.cloud.aws.secretsmanager.AwsSecretsManagerPropertySourceLocator;
import org.springframework.cloud.bootstrap.BootstrapApplicationListener;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration;
import org.springframework.cloud.bootstrap.marker.Marker;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.nativex.hint.*;

import java.util.HashSet;

@SpringBootApplication
@NativeHint(types = {
		@TypeHint(types = {
				RedisKeyValueAdapter.EnableKeyspaceEvents.class
		}),
		@TypeHint(types = {
				BootstrapConfiguration.class, PropertySourceBootstrapConfiguration.class,
				AwsSecretsManagerPropertySourceLocator.class, AwsSecretsManagerPropertySource.class,
				AwsSecretsManagerBootstrapConfiguration.class, AWSSecretsManager.class,
				BootstrapApplicationListener.class, Marker.class, InternalConfig.class,
				InternalConfigJsonHelper.class, JsonIndex.class, SignerConfig.class,
				SignerConfigJsonHelper.class, HttpClientConfig.class, HttpClientConfigJsonHelper.class,
				HostRegexToRegionMappingJsonHelper.class, CredentialsProviderFactoryBean.class,
				StaticRegionProvider.class, AmazonWebserviceClientFactoryBean.class,
				ClientConfiguration.class, Builder.class, AWSSecretsManagerClientBuilder.class,
				Partitions.class, Partition.class, Endpoint.class, HashSet.class, Region.class,
				Service.class, CredentialScope.class, AWS4Signer.class
		})
})
@JdkProxyHints({
		@JdkProxyHint(typeNames = {
				"org.apache.http.conn.HttpClientConnectionManager",
				"org.apache.http.pool.ConnPoolControl",
				"com.amazonaws.http.conn.Wrapped"
		}),
		@JdkProxyHint(typeNames = {
				"org.apache.http.conn.HttpClientConnectionManager",
				"org.apache.http.pool.ConnPoolControl",
				"java.io.Closeable"
		}),
		@JdkProxyHint(typeNames = {
				"org.apache.http.conn.ConnectionRequest",
				"com.amazonaws.http.conn.Wrapped"
		})
})
@ResourceHint(patterns = {
		"com/amazonaws/internal/config/awssdk_config_default.json",
		"com/amazonaws/partitions/endpoints.json",
		"org/joda/time/tz/data/ZoneInfoMap",
		"^org/joda/time/tz/data/Etc/.*"
})
public class SpringNativeDemoApplication {

	public static void main(String[] args) {
		System.setProperty("aws.accessKeyId", "<ACCESS_KEY>");
		System.setProperty("aws.secretKey", "<SECRET_KEY>");

		SpringApplication.run(SpringNativeDemoApplication.class, args);
	}
}