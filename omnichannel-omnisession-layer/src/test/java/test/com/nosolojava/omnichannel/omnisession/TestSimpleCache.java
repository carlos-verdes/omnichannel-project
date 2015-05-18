package test.com.nosolojava.omnichannel.omnisession;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nosolojava.omnichannel.omnisession.dto.OmnisessionInstance;
import com.nosolojava.omnichannel.omnisession.dto.OmnisessionUserInstance;

public class TestSimpleCache {

	private EmbeddedCacheManager cacheManager;

	@Before
	public void setupInfinispan() {
		cacheManager = new DefaultCacheManager();
	}

	@After
	public void stopInfinispan() {
		cacheManager.stop();
	}

	@Test
	public void testThatUserSessionIsSaved() {

		OmnisessionInstance sessionInstance = new OmnisessionInstance(
				"session1", "web", "jsessionid-123");
		OmnisessionUserInstance omniSessionUserInfo = new OmnisessionUserInstance(
				"cverdes");
		omniSessionUserInfo.addSession(sessionInstance);

		org.infinispan.Cache<String, OmnisessionUserInstance> userSessionCache = cacheManager
				.getCache();
		userSessionCache.put(omniSessionUserInfo.getUserId(),
				omniSessionUserInfo);

		OmnisessionUserInstance userInfoCached = userSessionCache
				.get(omniSessionUserInfo.getUserId());
		assertNotNull(userInfoCached);
		assertEquals(omniSessionUserInfo, userInfoCached);

	}

}
