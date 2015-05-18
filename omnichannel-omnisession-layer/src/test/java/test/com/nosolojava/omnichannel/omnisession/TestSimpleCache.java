package test.com.nosolojava.omnichannel.omnisession;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.com.nosolojava.omnichannel.omnisession.listener.UserInfoChangeLoggerListener;

import com.nosolojava.omnichannel.omnisession.dto.OmnisessionInstance;
import com.nosolojava.omnichannel.omnisession.dto.OmnisessionUserInstance;

public class TestSimpleCache {

	private static final String USER_CVERDES = "cverdes";
	private EmbeddedCacheManager cacheManager;
	private OmnisessionUserInstance userInstance;
	private org.infinispan.Cache<String, OmnisessionUserInstance> userSessionCache;

	@Before
	public void setupInfinispan() throws InterruptedException {

		ConfigurationBuilder config = new ConfigurationBuilder();
		cacheManager = new DefaultCacheManager(config.build());

		// create users mock and store in cache
		userInstance = mockUserInstance();
		userSessionCache = cacheManager.getCache();
		userSessionCache.addListener(new UserInfoChangeLoggerListener());
		userSessionCache.put(USER_CVERDES, userInstance);

	}

	@After
	public void stopInfinispan() {
		cacheManager.stop();
	}

	@Test
	public void testThatUserSessionIsSaved() {

		OmnisessionUserInstance userInstanceCached = userSessionCache.get(USER_CVERDES);
		assertNotNull(userInstanceCached);
		assertEquals(userInstance, userInstanceCached);

		userInstance.setUserId("otra cosa");
		userSessionCache.put(USER_CVERDES, userInstance);

	}

	private OmnisessionUserInstance mockUserInstance() {
		OmnisessionUserInstance omniSessionUserInfo = new OmnisessionUserInstance(USER_CVERDES);
		OmnisessionInstance sessionInstance = new OmnisessionInstance("session1", "web", "jsessionid-123");
		omniSessionUserInfo.addSession(sessionInstance);
		return omniSessionUserInfo;
	}

}
